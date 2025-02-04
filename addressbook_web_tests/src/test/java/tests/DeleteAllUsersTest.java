package tests;

import org.junit.jupiter.api.Test;

public class DeleteAllUsersTest extends TestBase {

    @Test
    public void CanDeleteUsers() {
        if (!app.users().isUserListPresent()) {
            app.users().createUser();
        }
        app.users().deleteAllUsers();

    }
}
