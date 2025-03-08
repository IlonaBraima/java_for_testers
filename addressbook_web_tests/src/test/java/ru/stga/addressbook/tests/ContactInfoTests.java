package ru.stga.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stga.addressbook.model.UserData;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        var users = app.hbm().getUserList();
        var expected = users.stream().collect(Collectors.toMap(UserData::id, user ->
            Stream.of(user.home(), user.mobile(), user.work(), user.phone2())
                    .filter(s -> s != null && ! "".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
            var phones = app.users().getPhones();
            Assertions.assertEquals(expected, phones);
        }

    @Test
    void testEmails() {
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        var users = app.hbm().getUserList();
        var expected = users.stream().collect(Collectors.toMap(UserData::id, user ->
                Stream.of(user.email(), user.email2(), user.email3())
                        .filter(t -> t != null && ! "".equals(t))
                        .collect(Collectors.joining("\n"))
                ));
        var emails = app.users().getEmails();
        Assertions.assertEquals(expected, emails);
    }

    @Test
    void testAddress() {
        if (app.hbm().getUserCount() == 0) {
            app.hbm().createUser(new UserData("", "firstname", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        var users = app.hbm().getUserList();
        var user = users.get(0);
        var address = app.users().getAddress(user);
        var expected = Stream.of(user.address())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, address);
    }

}
