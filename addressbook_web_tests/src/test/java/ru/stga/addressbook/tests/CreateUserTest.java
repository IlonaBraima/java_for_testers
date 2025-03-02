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
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static ru.stga.addressbook.common.CommonFunctions.randomString;

public class CreateUserTest extends TestBase {

            //Добавление photo

  @Test
  void canCreateContact(){
    var user = new UserData()
            .withFirstName(CommonFunctions.randomString(10))
            .withLastName(CommonFunctions.randomString(10))
            .withPhoto(randomFile("src/test/resources/images"));
    app.users().createUser(user);
  }

    @Test
    void canCreateContactInGroup(){
        var user = new UserData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getUsersInGroup(group);
        app.users().create(user, group);
        var newRelated = app.hbm().getUsersInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

}
          // Цикл со счётчиком: многократное повторение похожих действийСтраница
          // Параметризованные тесты
          //  Сравнение списков
          //   Сортировка списков

//  public static List<UserData> userProvider() throws IOException {
//      var result = new ArrayList<UserData>();
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
//
//      ObjectMapper mapper = new XmlMapper();
//      var value = mapper.readValue(new File("users.xml"), new TypeReference<List<UserData>>() {
//      });
//      result.addAll(value);
//      return result;
//
//
//    public static Stream<UserData> randomUsers() {
//        Supplier<UserData> randomUser = () -> new UserData()
//                .withFirstName(CommonFunctions.randomString(10))
// //             .withLastName(CommonFunctions.randomString(20))
//        return Stream.generate(randomUser).limit(1);
//    }
//
//    @ParameterizedTest
//    @MethodSource("randomUsers")
//
//  public void CanCreateUsers(UserData user) {
//    var oldUsers = app.jdbc().getUserList();
//    app.users().createUser(user);
//    var newUsers = app.jdbc().getUserList();
//
//    var extraUsers = newUsers.stream().filter(g -> ! oldUsers.contains(g)).toList();
//    var newId = extraUsers.get(0).id();
//
//
//    var expectedList = new ArrayList<>(oldUsers);
//    expectedList.add(user.withId(newId));
//    Assertions.assertEquals((Set.copyOf(newUsers), (Set.copyOf(expectedList));
// }
//
