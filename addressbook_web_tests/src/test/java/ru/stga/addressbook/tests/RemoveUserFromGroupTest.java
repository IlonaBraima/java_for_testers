package ru.stga.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;


import java.util.Random;

public class RemoveUserFromGroupTest extends TestBase {

    @Test
    public void canAddAndRemoveUserFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "Test Group", "Header", "Footer"));
        }
        var groups = app.hbm().getGroupList();
        var rnd = new Random();
        var group = groups.get(rnd.nextInt(groups.size()));
        var oldUsersInGroup = app.hbm().getUsersInGroup(group);
        if (oldUsersInGroup.isEmpty()) {
            var user = new UserData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            //app.hbm().createUser(user); // Создаем пользователя
            app.users().addUserToGroup(user, group); // Добавляем пользователя в группу
        }
        var newUsersInGroup = app.hbm().getUsersInGroup(group);
        Assertions.assertFalse(newUsersInGroup.isEmpty());

        var userToRemove = newUsersInGroup.get(0);
        app.users().removeContactFromGroup(group, userToRemove);

        var finalUsersInGroup = app.hbm().getUsersInGroup(group);
        Assertions.assertFalse(finalUsersInGroup.contains(userToRemove));
    }
}


