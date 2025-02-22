package ru.stga.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ru.stga.addressbook.common.CommonFunctions.randomString;

public class CreateUserTest extends TestBase {

            //Добавление photo

//  @Test
//  void canCreateContact(){
//    var user = new UserData()
//            .withFirstName(CommonFunctions.randomString(10))
//            .withLastName(CommonFunctions.randomString(10))
//            .withPhoto(randomFile("src/test/resources/images"));
//    app.users().createUser(user);
//  }


          // Цикл со счётчиком: многократное повторение похожих действийСтраница
          // Параметризованные тесты
          //  Сравнение списков
          //   Сортировка списков

  public static List<UserData> userProvider() throws IOException {
      var result = new ArrayList<UserData>();
//    for (var firstname : List.of("", "firstName")) {
//      for (var middlename : List.of("", "middleName")) {
//        for (var lastname : List.of("", "lastName")) {
//          for (var nickname : List.of("", "nickName")) {
//            for (var title : List.of("", "title")) {
//              for (var email : List.of("", "anoli@test.com"))
//                  result.add(new UserData()
//                          .withFirstName(firstname)
//                          .withMiddleName(middlename)
//                          .withLastName(lastname)
//                          .withNickName(nickname)
//                          .withTitle(title)
//                          .withEmail(email));
//            }
//          }
//        }
//      }
//    }
//        // генератор случайных названий
//      for (int i = 0; i < 5; i++) {
//        result.add(new UserData(
//                "",
//                randomString(i * 10),
//                randomString(i * 10),
//                randomString(i * 10),
//                randomString(i * 10),
//                randomString(i * 10),
//                randomString(i * 10),
//                randomString(1)));
//      }
//      return result;
//    }

      //чтение файлов 1-ый способ. Чтение файла целиком
//        var json = Files.readString(Paths.get("users.json"));
//        ObjectMapper mapper = new ObjectMapper();
//        var value = mapper.readValue(json, new TypeReference<List<UserData>>() {
//        });
//        result.addAll(value);
//        return result;
//    }

      //чтение файлов XML

      ObjectMapper mapper = new XmlMapper();
      var value = mapper.readValue(new File("users.xml"), new TypeReference<List<UserData>>() {
      });
      result.addAll(value);
      return result;
  }

    public static List<UserData> singleRandomUser() {
        return List.of(new UserData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(20)));
    }

    @ParameterizedTest
  @MethodSource("singleRandomUser")

  public void CanCreateUsers(UserData user) {
    var oldUsers = app.jdbc().getUserList();
    app.users().createUser(user);
    var newUsers = app.jdbc().getUserList();
    Comparator<UserData> compareById = (a1, a2) -> {
      return Integer.compare(Integer.parseInt(a1.id()), Integer.parseInt(a2.id()));
    };
    newUsers.sort(compareById);
    var maxId = newUsers.get(newUsers.size() - 1).id();


    var expectedList = new ArrayList<>(oldUsers);
    expectedList.add(user.withId(maxId));
    expectedList.sort(compareById);
    Assertions.assertEquals(newUsers, expectedList);
  }

}