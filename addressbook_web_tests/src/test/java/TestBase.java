import model.GroupData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {
    protected static WebDriver driver;

    protected static void createUser() {
      driver.findElement(By.linkText("add new")).click();
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys("First name");
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).sendKeys("Middle name");
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys("Last name");
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).sendKeys("Nickname");
      driver.findElement(By.name("title")).click();
      driver.findElement(By.name("title")).sendKeys("Title");
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("company")).click();
      driver.findElement(By.name("company")).sendKeys("Company");
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys("Address");
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("home")).sendKeys("12345");
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys("12345");
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("work")).sendKeys("12354");
      driver.findElement(By.name("fax")).click();
      driver.findElement(By.name("fax")).sendKeys("12345");
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys("test@test.com");
      driver.findElement(By.name("email2")).click();
      driver.findElement(By.name("email2")).sendKeys("test1@test.com");
      driver.findElement(By.name("email3")).click();
      driver.findElement(By.name("email3")).sendKeys("test2@test.com");
      driver.findElement(By.name("homepage")).click();
      driver.findElement(By.name("homepage")).sendKeys("homepage");
      driver.findElement(By.name("bday")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bday"));
        dropdown.findElement(By.xpath("//option[. = '1']")).click();
      }
      driver.findElement(By.name("bmonth")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bmonth"));
        dropdown.findElement(By.xpath("//option[. = 'January']")).click();
      }
      driver.findElement(By.name("byear")).click();
      driver.findElement(By.name("byear")).sendKeys("1990");
      driver.findElement(By.name("aday")).click();
      {
        WebElement dropdown = driver.findElement(By.name("aday"));
        dropdown.findElement(By.xpath("//option[. = '1']")).click();
      }
      driver.findElement(By.name("amonth")).click();
      {
        WebElement dropdown = driver.findElement(By.name("amonth"));
        dropdown.findElement(By.xpath("//option[. = 'January']")).click();
      }
      driver.findElement(By.name("ayear")).click();
      driver.findElement(By.name("ayear")).sendKeys("2000");
      driver.findElement(By.name("submit")).click();

    }

    protected static void removeUser() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click ();
      driver.get("http://localhost/addressbook/");
      driver.findElement(By.id("MassCB")).click();
      driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();

    }

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(970, 668));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).click();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void createGroup(GroupData groupData) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    protected void openGroupPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    protected boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    protected void openAddNewUserPage() {
      if (! isElementPresent(By.name("submit"))) {
          driver.get("http://localhost/addressbook/group.php");
      }
    }

    protected void openHomePage() {
      if (!isElementPresent(By.id("MassCB"))) {
        driver.get("http://localhost/addressbook/");
      }
    }

    protected boolean isUserListPresent() {
      return isElementPresent(By.name("entry"));
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
