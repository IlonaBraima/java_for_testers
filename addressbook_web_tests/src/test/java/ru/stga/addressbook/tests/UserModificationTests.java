package ru.stga.addressbook.tests;

import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class UserModificationTests extends TestBase {

    @Test
    void canModifyUser() {
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        var oldUsers = app.hbm().getUserList();
        var rnd = new Random();
        var index = rnd.nextInt(oldUsers.size());
        var testData = new UserData().withFirstName(CommonFunctions.randomString(13));
        app.users().modifyUser(oldUsers.get(index), testData);
        var newUsers = app.hbm().getUserList();
        var expectedList = new ArrayList<>(oldUsers);
        expectedList.set(index, testData.withId(oldUsers.get(index).id()));
        Assertions.assertEquals(Set.copyOf(newUsers), Set.copyOf(expectedList));
    }
}
