package tests;

import model.UserData;
import org.junit.jupiter.api.Test;

public class UserModificationTests extends TestBase {

    @Test
    void canModifyUser() {
        if (app.users().getCount() == 0) {
            app.users().createUser(new UserData());
        }
        app.users().modifyUser(new UserData().withFirstName("modified name"));
    }
}
