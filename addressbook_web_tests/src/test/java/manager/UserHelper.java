package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper {

    private final ApplicationManager manager;

  //  public WebDriver driver;

    public UserHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void createUser() {
        openAddNewUserPage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys("First name");
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys("Middle name");
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys("Last name");
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys("Nickname");
        manager.driver.findElement(By.name("title")).click();
        manager.driver.findElement(By.name("title")).sendKeys("Title");
        manager.driver.findElement(By.name("theform")).click();
        manager.driver.findElement(By.name("company")).click();
        manager.driver.findElement(By.name("company")).sendKeys("Company");
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys("Address");
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys("12345");
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys("12345");
        manager.driver.findElement(By.name("work")).click();
        manager.driver.findElement(By.name("work")).sendKeys("12354");
        manager.driver.findElement(By.name("fax")).click();
        manager.driver.findElement(By.name("fax")).sendKeys("12345");
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys("test@test.com");
        manager.driver.findElement(By.name("email2")).click();
        manager.driver.findElement(By.name("email2")).sendKeys("test1@test.com");
        manager.driver.findElement(By.name("email3")).click();
        manager.driver.findElement(By.name("email3")).sendKeys("test2@test.com");
        manager.driver.findElement(By.name("homepage")).click();
        manager.driver.findElement(By.name("homepage")).sendKeys("homepage");
        manager.driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        manager.driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys("1990");
        manager.driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        manager.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys("2000");
        manager.driver.findElement(By.name("submit")).click();

    }

    public void removeUser() {
        openHomePage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
        manager.driver.get("http://localhost/addressbook/");
        manager.driver.findElement(By.id("MassCB")).click();
        manager.driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();

    }

    public void openAddNewUserPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            manager.driver.get("http://localhost/addressbook/group.php");
        }
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.id("MassCB"))) {
            manager.driver.get("http://localhost/addressbook/");
        }
    }

    public boolean isUserListPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("entry"));
    }

    public boolean isAlertPresent() {
        openHomePage();
        try {
            manager.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
