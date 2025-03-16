package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UsersHelper extends HelperBase {

    public UsersHelper(ApplicationManager manager) {
        super(manager);
    }

    public void startCreation(String user, String email) {
        if (!manager.session().isLoggedIn()) {
            manager.session().login(manager.property("web.username"), manager.property("web.password"));
        }
        manager.driver().get(String.format("%s/manage_user_create_page.php", manager.property("web.password")));
        type(By.name("username"), user);
        type(By.name("realname"), user);
        type(By.name("email"), email);
        click(By.cssSelector("input[type='submit']"));
    }

    public void delete(String user) {
        if (!manager.session().isLoggedIn()) {
            manager.session().login(manager.property("web.username"), manager.property("web.password"));
        }
        manager.driver().get(String.format("%s/manage_user_page.php", manager.property("web.BaseUrl")));

//        public void startCreation(String user) {
//            var email = String.format("%s@localhost", user);
//            if (!manager.session().isLoggedIn()) {
//                manager.session().login(manager.property("web.username"), manager.property("web.password"));
//            }
//            manager.driver().get(String.format("%s/manage_user_create_page.php", manager.property("web.password")));
//            type(By.name("username"), user);
//            type(By.name("realname"), user);
//            type(By.name("email"), email);
//            click(By.cssSelector("input[type='submit']"));
//        }

    }


    public void finishCreation(String url, String password) {
    }
}
