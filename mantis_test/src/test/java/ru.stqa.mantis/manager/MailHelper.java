package ru.stqa.mantis.manager;

import jakarta.mail.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.MailMessage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MailHelper extends HelperBase {

    public MailHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<MailMessage> receive(String username, String password, Duration duration) {
        var start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + duration.toMillis()) {
            try {
                var inbox = getInbox(username, password);
                inbox.open(Folder.READ_ONLY);
                var messages = inbox.getMessages();
                var result = Arrays.stream(messages)
                        .map(m -> {
                            try {
                                return new MailMessage()
                                        .withFrom(m.getFrom()[0].toString())
                                        .withContent((String) m.getContent());
                            } catch (MessagingException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .toList();
                inbox.close();
                inbox.getStore().close();
                if (result.size() > 0) {
                    return result;
                }
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("No mail");
    }

    private static Folder getInbox(String username, String password) {
        try {
            var session = Session.getInstance(new Properties());
            Store store = session.getStore("pop3");
            store.connect("localhost", username, password);
            var inbox = store.getFolder("INBOX");
            return inbox;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void drain(String username, String password) {
        var inbox = getInbox(username, password);
        try {
            inbox.open(Folder.READ_WRITE);
            Arrays.stream(inbox.getMessages()).forEach(m -> {
                try {
                    m.setFlag(Flags.Flag.DELETED, true);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            });
            inbox.close();
            inbox.getStore().close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Вспомогательный метод для ввода текста
    private void enterText(By locator, String text) {
        WebElement element = manager.driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillRegistrationForm() {
        enterText(By.name("username"), "user1");
        enterText(By.name("email"), "user1@localhost");
    }

    public void openRegistrationPage() {
        if (!manager.isElementPresent(By.id("signup-form"))) {
           // manager.driver.get("http://localhost/mantisbt-2.26.2/signup_page.php");
            click(By.linkText("groups"));
        }

//    public void openGroupPage() {
//        if (!manager.isElementPresent(By.name("new"))) {
//            click(By.linkText("groups"));
//        }
    }

    public void submitRegistrationForm() {
        manager.driver.findElement(By.cssSelector("input[type='submit'].btn.btn-primary.btn-white.btn-round"));
    }

    //public void openUrl(String url) {
       // app.mail().openUrl(url);
   // }

//    public static String extractUrlFromMessage(String text) {
//        Pattern pattern = Pattern.compile("http://\\S+");
//        var matcher = pattern.matcher(text);
//        if (matcher.find()) {
//            var url = text.substring(matcher.start(), matcher.end());
//            return url;
//        }
//        return null;
//    }

    public static String extractUrlFromMessage(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Message text is null or empty");
        }
        Pattern pattern = Pattern.compile("(https?://\\S+)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new RuntimeException("No URL found in message");
    }

    public void login() {
    }

    public void completeRegistration() {
        enterText(By.name("realname"), "user1");
        enterText(By.name("password"), "password");
        enterText(By.name("password_confirm"), "password");
        manager.driver.findElement(By.cssSelector("button.btn-success")).click();
    }

    public void finishCreation(String user) {
    }
}