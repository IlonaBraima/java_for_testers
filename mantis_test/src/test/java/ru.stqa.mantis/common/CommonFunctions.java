package ru.stqa.mantis.common;

import org.junit.jupiter.api.Assertions;

import java.util.Random;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        Supplier<Integer> randomNumber = () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumber)
                .limit(n)
                .map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());
        return result;
    }

    public static String extractUrl(String content) {
        Pattern pattern = Pattern.compile("http://[^\\s\"]+");  // Регулярное выражение для поиска URL
        Matcher matcher = pattern.matcher(content);

        Assertions.assertTrue(matcher.find(), "GUID не найден в письме!");  // Проверяем, найден ли URL

        return matcher.group(0);  // Извлекаем найденный URL
    }

}