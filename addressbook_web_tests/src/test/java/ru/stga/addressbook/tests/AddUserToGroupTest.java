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
            app.hbm().createGroup(new GroupData("", "Test Group", "Header", "Footer"));
        }

        var groups = app.hbm().getGroupList();
        var rnd = new Random();
        var group = groups.get(rnd.nextInt(groups.size()));

        var oldUsersInGroup = app.hbm().getUsersInGroup(group);

        var user = new UserData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));

        app.users().addUserToGroup(user, group); // Добавляем пользователя в группу

        var newUsersInGroup = app.hbm().getUsersInGroup(group);
        int newSize = newUsersInGroup.size(); // Получаем новый размер списка

        Assertions.assertTrue(newSize >= 1, "Количество пользователей в группе должно быть больше или равно 1");
    }
}