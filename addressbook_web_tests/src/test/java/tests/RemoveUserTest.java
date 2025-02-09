package tests;

import model.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveUserTest extends TestBase {

    @Test
    public void CanRemoveUser() {
        if (app.users().getCount() == 0) {
            app.users().createUser(new UserData());
        }
        int userCount = app.users().getCount();
        app.users().removeUser();
        int newUserCount = app.users().getCount();
        Assertions.assertEquals(userCount - 1, newUserCount);
    }
}



