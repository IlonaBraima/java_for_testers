package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.manager.MailHelper;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class UserRegTests extends TestBase {

    DeveloperMailUser user;

    public static Stream<String> randomUsernames() {
        var sLength = 5;
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return CommonFunctions.randomString(sLength);
            }
        };

        var n = 1;
        var stream = Stream.generate(supplier).limit(n);
        return stream;
    }

//         1. Создаём пользователя в JamesHelper
//         2. Заполняем форму регистрации и отправляем через браузер
//         3. Очищаем ящик перед проверкой
//         4. Ожидаем письмо с подтверждением
//         5. Извлекаем ссылку подтверждения
//         6. Переходим по ссылке и завершаем регистрацию
//         7. Проверяем, что пользователь может залогиниться

    @ParameterizedTest
    @MethodSource("randomUsernames")
    void canRegisterUser(String username) {
        var email = String.format("%s@localhost", username);
        var password = CommonFunctions.randomString(10);

        // 1. Создаём пользователя в JamesHelper
        DeveloperMailUser user = app.jamesCli().addUser(email, password);
        if (user == null) {
            throw new RuntimeException("User is null after CLI addUser() call!");
        }

        // 3. Очищаем ящик перед проверкой (добавляем drain)
        app.mail().drain(email, password);

        // 2. Заполняем форму регистрации и отправляем через браузер
        app.session().signUpForNewAccount(username, email);

        // 4. Ожидаем письмо с подтверждением
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        Assertions.assertFalse(messages.isEmpty(), "No confirmation email received for: " + email);

        // 5. Извлекаем ссылку подтверждения
        var url = MailHelper.extractUrlFromMessage(messages.get(0).content());
        Assertions.assertNotNull(url, "Activation URL not found in email!");

        // 6. Переходим по ссылке и завершаем регистрацию
        app.session().goToUrl(url);
        app.session().updateUser(username, password);

        // 7. Проверяем, что пользователь может залогиниться
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn(), "Login failed after registration!");
    }

//    Тест регистрирует новый адрес на почтовом сервере James, используя REST API.
//    Сценарий начинает регистрацию нового пользователя в Mantis, используя REST API.
//    Mantis отправляет письмо на указанный адрес, тест должен получить это письмо, извлечь из него ссылку для подтверждения, пройти по этой ссылке и завершить регистрацию.
//    Затем тест должен проверить, что пользователь может войти в систему с новым паролем. Этот шаг можно выполнить на уровне протокола HTTP.

//    @ParameterizedTest
//    @MethodSource("randomUsernames")
//    public void canRegisterUserWithJamesApi(String username) {
//        var email = String.format("%s@localhost", username);
//        var password = "password";
//
//       app.jamesApi().addUser(email, password);
//        System.out.println("User after addUser(): " + user);
//        app.session().signUpForNewAccount(username, email);
//        if (user != null) {
//            System.out.println(user.name());
//        } else {
//            throw new RuntimeException("User is null");
//        }
//        System.out.println("API response text: " + text);
//        var messages = app.mail().receive(email, password, Duration.ofSeconds(180));
//        var url = MailHelper.extractUrlFromMessage(messages.get(0).content());
//        Assertions.assertNotNull(url);
//
//        app.session().goToUrl(url);
//        app.session().updateUser(username, password);
//
//        app.http().login(username, password);
//        Assertions.assertTrue(app.http().isLoggedIn());
//    }
//
//    @Test
//    public void canRegisterUserWithDeveloperMail() {
//        var password = "password";
//        user = app.developerMail().addUser();
//        var email = String.format("%s@developermail.com", user);
//    }

//    @AfterEach
//    void deleteMailUser() {
//        app.developerMail().deleteUser(user);
//    }
}