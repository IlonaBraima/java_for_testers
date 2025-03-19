package ru.stga.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;


import java.util.Random;


public class AddUserToGroupTest extends TestBase {

    @Test
    public void canAddUserToGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(
                    new GroupData("", "Test Group", "Header", "Footer"));
        }

        var group = app.hbm().getGroupList().get(0);
        if (app.hbm().getUserCount() == 0) {
        app.users().createUser(new UserData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10)));
        }

        var user = app.hbm().getUserList().get(0);
        var oldRelated = app.hbm().getUsersInGroup(group);
         app.users().addUserToGroup(user, group);
         var newRelated = app.hbm().getUsersInGroup(group);
         Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

}

