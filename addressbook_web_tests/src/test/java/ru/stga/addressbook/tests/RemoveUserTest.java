package ru.stga.addressbook.tests;

import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
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
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", ""));
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
    @Test
    public void CanRemoveContactFromGroup() {
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", ""));
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
//
//    void canCreateContactInGroup(){
//        var user = new UserData()
//                .withFirstName(CommonFunctions.randomString(10))
//                .withLastName(CommonFunctions.randomString(10))
//                .withPhoto(randomFile("src/test/resources/images"));
//        if (app.hbm().getGroupCount() == 0) {
//            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
//        }
//        var group = app.hbm().getGroupList().get(0);
//
//        var oldRelated = app.hbm().getUsersInGroup(group);
//        app.users().create(user, group);
//        var newRelated = app.hbm().getUsersInGroup(group);
//        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
//    }

}



