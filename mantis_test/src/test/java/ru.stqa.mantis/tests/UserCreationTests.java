package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;
import java.util.stream.Stream;

public class UserCreationTests extends TestBase {

DeveloperMailUser user;

//test https://developermail.com/api/v1/

    @Test
    void canCreateUser() {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

//        app.mail().startCreation(user);
//
//        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
//        var url = CommonFunctions.extractUrl(messages.get(0).content());
//
//        app.mail().finishCreation(user);
//
//        app.http().login(user, password);
//        Assertions.assertTrue(app.http().isLoggedIn());

    }

        @AfterEach
        void deleteMailUser() {
            app.developerMail().deleteUser(user);
        }

    }

    // public static Stream<String> randomUser() {
    //        return Stream.of(CommonFunctions.randomString(8));
    //    }

    //test API JAMES
//    @ParameterizedTest
//    @MethodSource("randomUser")
//    void canCreateUser(String user) {
//        var email = String.format("%s@localhost", user);
//        var password = "password";
//        app.jamesApi().addUser(email, password);
//
//        app.mail().startCreation(user);
//
//        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
//        var url = CommonFunctions.extractUrl(messages.get(0).content());
//
//        app.mail().finishCreation(user);
//
//        app.http().login(user, password);
//        Assertions.assertTrue(app.http().isLoggedIn());
//
//    }

    //тест для ручного создания

//    @ParameterizedTest
//    @MethodSource("randomUser")
//    void canCreateUser(String user) {
//        var email = String.format("%s@localhost", user);
//        var password = "password";
//        app.jamesCli().addUser(email, password);
//
//        app.user().startCreation(user);
//
//        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
//        var url = CommonFunctions.extractUrl(messages.get(0).content());
//
//        app.user().finishCreation(user);
//
//        app.http.login(user, password);
//        Assertions.assertTrue(app.http().isLoggedIn());
//
//    }

