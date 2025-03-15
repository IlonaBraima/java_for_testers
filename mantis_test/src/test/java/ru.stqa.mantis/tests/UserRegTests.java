package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegTests extends TestBase {

    @Test
    void CanRegisterUser() {
        // 1. Создаём пользователя в JamesHelper
        app.jamesCli().addUser("%s@localhost", "password");

        // 2. Заполняем форму регистрации и отправляем через браузер
        app.mail().openRegistrationPage();
        app.mail().fillRegistrationForm();
        app.mail().submitRegistrationForm();

        // 3. Очищаем ящик перед проверкой
        app.mail().drain("%s@localhost", "password");

        // 4. Ожидаем письмо с подтверждением
        var messages = app.mail().receive("%s@localhost", "password", Duration.ofSeconds(60));
        Assertions.assertFalse(messages.isEmpty(), "Письмо не пришло!");

        // 5. Извлекаем ссылку подтверждения
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find(), "GUID не найден в письме!");
        var guid = matcher.group(1);

        // 6. Переходим по ссылке и завершаем регистрацию
        var confirmationUrl = String.format("http://http://localhost/mantisbt-2.26.2/verify.php?id=3&confirm_hash?guid=%s", guid);
        app.mail().openUrl(confirmationUrl);
        app.mail().completeRegistration();

        // 7. Проверяем, что пользователь может залогиниться
        var session = app.http();
        session.login("%s@localhost", "password");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(session.isLoggedIn(), "Логин не удался!");
    }
}