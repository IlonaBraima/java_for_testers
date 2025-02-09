package tests;

import model.UserData;

import org.junit.jupiter.api.Test;

public class DeleteAllUsersTest extends TestBase {

    @Test
    public void CanDeleteUsers() {
        if (!app.users().isUserListPresent()) {
            app.users().createUser(new UserData());
        }
        app.users().deleteAllUsers();

    }
}
