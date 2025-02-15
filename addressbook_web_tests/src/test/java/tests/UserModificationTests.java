package tests;

import model.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class UserModificationTests extends TestBase {

    @Test
    void canModifyUser() {
        if (app.users().getCount() == 0) {
            app.users().createUser(new UserData("", "", "", "", "", "", "", ""));
        }
        var oldUsers = app.users().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldUsers.size());
        var testData = new UserData().withFirstName("modified name");
        app.users().modifyUser(oldUsers.get(index), testData);
        var newUsers = app.users().getList();
        var expectedList = new ArrayList<>(oldUsers);
        expectedList.set(index, testData.withId(oldUsers.get(index).id()));
        Comparator<UserData> CompareById = (a1, a2) -> {
            return Integer.compare(Integer.parseInt(a1.id()), Integer.parseInt(a2.id()));
        };
        newUsers.sort(CompareById);
        expectedList.sort(CompareById);
        Assertions.assertEquals(newUsers, expectedList);
    }
}
