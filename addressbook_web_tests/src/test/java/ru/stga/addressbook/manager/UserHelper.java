package ru.stga.addressbook.manager;

import ru.stga.addressbook.model.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createUser(UserData user) {
        openAddNewUserPage();
        initNewNameCreation();
        //fillUserForm(user);
        fillPersonalDetails(user);
        submitUserCreation();
        openHomePage();
    }

    public void removeUser(UserData user) {
        openHomePage();
        SelectedUser(user);
        removeSelectedUser();
        openHomePage();
    }

    public void deleteAllUsers() {
        openHomePage();
        removeUser(null);
        removedAllUsers();
        switchtToAlert();
    }

    public void fillUserForm(UserData user) {
        fillCompanyDetails();
        fillContactDetails();
        fillEmailsAndWebsite(user);
        fillBirthAndAnniversary();
    }

    public void modifyUser(UserData user, UserData modifiedUser) {
        openHomePage();
        //SelectedUser(user);
        initUserModification();
        submitUserModify();
        fillPersonalDetails(user);
        submitUserModification();
        returnToHomePage();
    }

    private void fillPersonalDetails(UserData user) {
        type(By.name("firstname"), user.firstname());
        enterText(By.name("middlename"), user.middlename());
        enterText(By.name("lastname"), user.lastname());
        enterText(By.name("nickname"), user.nickname());
        enterText(By.name("title"), user.title());
        //attach(By.name("photo"), user.photo());
    }


    private void fillCompanyDetails() {
        enterText(By.name("company"), "Company");
        enterText(By.name("address"), "Address");
    }
    private void fillContactDetails() {
        enterText(By.name("home"), "12345");
        enterText(By.name("mobile"), "12345");
        enterText(By.name("work"), "12354");
        enterText(By.name("fax"), "12345");
    }

    private void fillEmailsAndWebsite(UserData user) {
        enterText(By.name("email"), user.email());
        enterText(By.name("email2"), "test1@test.com");
        enterText(By.name("email3"), "test2@test.com");
        enterText(By.name("homepage"), "homepage");
    }

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

    private void removeSelectedUser() {
        manager.driver.findElement(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input")).click(); }

    public void openAddNewUserPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            manager.driver.get("web.baseGroupUrl");
        }
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.id("MassCB"))) {
            manager.driver.get("web.baseUrl");
        }
    }

    public boolean isUserListPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("entry"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitUserModification() {
        click(By.name("update"));
    }

    private void submitUserModify() {
        click(By.xpath("/html/body/div/div[4]/form[1]/input[2]"));
    }

    public void SelectedUser(UserData user) {
        click(By.cssSelector(String.format("input[value='%s']", user.id())));
    }

    public void initUserModification() {
        click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[3]/td[7]/a"));
        //click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a"));

        ///driver.findElements(By.className("fdTableSortTrigger")); ищет элементы только по одному классу.
        //driver.findElements(By.cssSelector(".fdTableSortTrigger")); более гибкий, можно комбинировать с другими селекторами (например, div.fdTableSortTrigger).
    }

    public List<UserData> getList() {
        openHomePage();
        var users = new ArrayList<UserData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var firstname = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            //(By.xpath(".//td[3]")).getText();
            var lastname = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            users.add(new UserData().withId(id).withFirstName(firstname).withLastName(lastname));
        }
        return users;
    }
}