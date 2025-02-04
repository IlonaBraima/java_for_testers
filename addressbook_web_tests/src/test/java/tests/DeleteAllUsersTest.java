package tests;

import org.junit.jupiter.api.Test;

public class DeleteAllUsersTest extends TestBase {

    @Test
    public void CanDeleteUsers() {

        app.users().deleteAllUsers();
        app.acceptAlert();

    }
}
