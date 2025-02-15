package tests;

import model.UserData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreateUserTest extends TestBase {

 //Добавление photo

  @Test
  void canCreateContact(){
    var user = new UserData()
            .withFirstName(randomString(10))
            .withLastName(randomString(10))
            .withPhoto("src/test/resources/images/avatar.png");
    app.users().createUser(user);
  }


// Цикл со счётчиком: многократное повторение похожих действийСтраница
// Параметризованные тесты
  //Сравнение списков
  // Сортировка списковСтраница
//  public static List<UserData> userProvider() {
//    var result = new ArrayList<UserData>();
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
//
//      for (int i = 0; i < 5; i++) {
//        result.add(new UserData("", randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(1)));
//      }
//      return result;
//    }
//
//  @ParameterizedTest
//  @MethodSource("userProvider")
//
//  public void CanCreateMultipleUsers(UserData user) {
//    var oldUsers = app.users().getList();
//    app.users().createUser(user);
//    var newUsers = app.users().getList();
//    Comparator<UserData> compareById = (a1, a2) -> {
//      return Integer.compare(Integer.parseInt(a1.id()), Integer.parseInt(a2.id()));
//    };
//    newUsers.sort(compareById);
//    var expectedList = new ArrayList<>(oldUsers);
//    expectedList.add(user.withId(newUsers.get(newUsers.size() - 1)
//                    .id())
//            .withMiddleName("")
//            .withNickName("")
//            .withTitle("")
//            .withEmail("")
//    );
//    expectedList.sort(compareById);
//    Assertions.assertEquals(newUsers, expectedList);
//  }

}