package ru.stga.addressbook.tests;

import ru.stga.addressbook.model.UserData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class RemoveUserTest extends TestBase {

    @Test
    public void CanRemoveUser() {
        //app.users().openHomePage();
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        var oldUsers = app.hbm().getUserList();
        var rnd = new Random();
        var index = rnd.nextInt(oldUsers.size());
        app.users().removeUser(oldUsers.get(index));
        var newUsers = app.hbm().getUserList();
        var expectedList = new ArrayList<>(oldUsers);
        expectedList.remove(index);
        Assertions.assertEquals(newUsers, expectedList);
    }
}



