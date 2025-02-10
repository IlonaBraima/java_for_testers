package tests;

import model.UserData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class RemoveUserTest extends TestBase {

    @Test
    public void CanRemoveUser() {
        app.users().openHomePage();
        if (app.users().getCount() == 0) {
            app.users().createUser(new UserData());
        }
        var oldUsers = app.users().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldUsers.size());
        app.users().removeUser(oldUsers.get(index));
        var newUsers = app.users().getList();
        var expectedList = new ArrayList<>(oldUsers);
        expectedList.remove(index);
        Assertions.assertEquals(newUsers, expectedList);
    }
}



