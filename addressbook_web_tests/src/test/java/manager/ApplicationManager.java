package manager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ApplicationManager {

    protected WebDriver driver;

    private LoginHelper session;

    private GroupHelper groups;

    private UserHelper users;


    public void init(String browser) {
        if (driver == null) {
            if ("chrome".equals(browser)){
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                    driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(970, 668));
            session().login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper (this);
        }
        return groups;
    }

    public UserHelper users() {
        if (users == null) {
            users = new UserHelper (this);
        }
        return users;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
