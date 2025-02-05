package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createUser() {
        openAddNewUserPage();
        initNewNameCreation();
        fillUserForm();
        submitUserCreation();
        openHomePage();

    }

    public void removeUser() {
        openHomePage();
        removedAllUsers();
        openHomePage();
    }

    public void deleteAllUsers() {
        openHomePage();
        removeUser();
        removedAllUsers();
        switchtToAlert();
    }

    public void fillUserForm() {
        fillPersonalDetails();
        fillCompanyDetails();
        fillContactDetails();
        fillEmailsAndWebsite();
        fillBirthAndAnniversary();
    }

    // Заполнение личных данных
    private void fillPersonalDetails() {
        enterText(By.name("firstname"), "First name");
        enterText(By.name("middlename"), "Middle name");
        enterText(By.name("lastname"), "Last name");
        enterText(By.name("nickname"), "Nickname");
        enterText(By.name("title"), "Title");
    }

    // Заполнение данных о компании
    private void fillCompanyDetails() {
        enterText(By.name("company"), "Company");
        enterText(By.name("address"), "Address");
    }

    // Заполнение контактной информации
    private void fillContactDetails() {
        enterText(By.name("home"), "12345");
        enterText(By.name("mobile"), "12345");
        enterText(By.name("work"), "12354");
        enterText(By.name("fax"), "12345");
    }

    // Заполнение email и веб-сайта
    private void fillEmailsAndWebsite() {
        enterText(By.name("email"), "test@test.com");
        enterText(By.name("email2"), "test1@test.com");
        enterText(By.name("email3"), "test2@test.com");
        enterText(By.name("homepage"), "homepage");
    }

    // Заполнение даты рождения и годовщины
    private void fillBirthAndAnniversary() {
        selectDropdownValue(By.name("bday"), "1");
        selectDropdownValue(By.name("bmonth"), "January");
        enterText(By.name("byear"), "1990");

        selectDropdownValue(By.name("aday"), "1");
        selectDropdownValue(By.name("amonth"), "January");
        enterText(By.name("ayear"), "2000");
    }

    // Вспомогательный метод для ввода текста
    private void enterText(By locator, String text) {
        WebElement element = manager.driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    // Вспомогательный метод для выбора значения в выпадающем списке
    private void selectDropdownValue(By locator, String value) {
        WebElement dropdown = manager.driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '" + value + "']")).click();

//    private void fillUserForm() {
//        manager.driver.findElement(By.name("firstname")).click();
//        manager.driver.findElement(By.name("firstname")).sendKeys("First name");
//        manager.driver.findElement(By.name("middlename")).click();
//        manager.driver.findElement(By.name("middlename")).sendKeys("Middle name");
//        manager.driver.findElement(By.name("lastname")).click();
//        manager.driver.findElement(By.name("lastname")).sendKeys("Last name");
//        manager.driver.findElement(By.name("nickname")).click();
//        manager.driver.findElement(By.name("nickname")).sendKeys("Nickname");
//        manager.driver.findElement(By.name("title")).click();
//        manager.driver.findElement(By.name("title")).sendKeys("Title");
//        manager.driver.findElement(By.name("theform")).click();
//        manager.driver.findElement(By.name("company")).click();
//        manager.driver.findElement(By.name("company")).sendKeys("Company");
//        manager.driver.findElement(By.name("address")).click();
//        manager.driver.findElement(By.name("address")).sendKeys("Address");
//        manager.driver.findElement(By.name("mobile")).click();
//        manager.driver.findElement(By.name("home")).click();
//        manager.driver.findElement(By.name("home")).sendKeys("12345");
//        manager.driver.findElement(By.name("mobile")).click();
//        manager.driver.findElement(By.name("mobile")).sendKeys("12345");
//        manager.driver.findElement(By.name("work")).click();
//        manager.driver.findElement(By.name("work")).sendKeys("12354");
//        manager.driver.findElement(By.name("fax")).click();
//        manager.driver.findElement(By.name("fax")).sendKeys("12345");
//        manager.driver.findElement(By.name("email")).click();
//        manager.driver.findElement(By.name("email")).sendKeys("test@test.com");
//        manager.driver.findElement(By.name("email2")).click();
//        manager.driver.findElement(By.name("email2")).sendKeys("test1@test.com");
//        manager.driver.findElement(By.name("email3")).click();
//        manager.driver.findElement(By.name("email3")).sendKeys("test2@test.com");
//        manager.driver.findElement(By.name("homepage")).click();
//        manager.driver.findElement(By.name("homepage")).sendKeys("homepage");
//        manager.driver.findElement(By.name("bday")).click();
//        {
//            WebElement dropdown = manager.driver.findElement(By.name("bday"));
//            dropdown.findElement(By.xpath("//option[. = '1']")).click();
//        }
//        manager.driver.findElement(By.name("bmonth")).click();
//        {
//            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
//            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
//        }
//        manager.driver.findElement(By.name("byear")).click();
//        manager.driver.findElement(By.name("byear")).sendKeys("1990");
//        manager.driver.findElement(By.name("aday")).click();
//        {
//            WebElement dropdown = manager.driver.findElement(By.name("aday"));
//            dropdown.findElement(By.xpath("//option[. = '1']")).click();
//        }
//        manager.driver.findElement(By.name("amonth")).click();
//        {
//            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
//            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
//        }
//        manager.driver.findElement(By.name("ayear")).click();
//        manager.driver.findElement(By.name("ayear")).sendKeys("2000");
  }

    private void removedAllUsers() {
        manager.driver.findElement(By.id("MassCB")).click();
        manager.driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
    }

    private void switchtToAlert() {
        manager.driver.switchTo().alert().accept();
    }

    private void submitUserCreation() {
        manager.driver.findElement(By.name("submit")).click();
    }

    private void initNewNameCreation() {
        manager.driver.findElement(By.linkText("add new")).click();
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

}