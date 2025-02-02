import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateUserTest extends TestBase {

  @Test
  public void createUser() {
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
    driver.findElement(By.name("new_group")).click();
    {
      WebElement dropdown = driver.findElement(By.name("new_group"));
      dropdown.findElement(By.xpath("//option[. = 'group name']")).click();
    }
    driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
  }
}
