package tests;

import org.junit.jupiter.api.Test;

public class RemoveUserTest extends TestBase {

    @Test
    public void CanRemoveUser() {
        if (!app.users().isUserListPresent()) {
            app.users().createUser();
        }
        app.users().removeUser();

//        if (app.users().isAlertPresent()) {
//            app.users().driver.switchTo().alert().accept();
//        }
    }
}

