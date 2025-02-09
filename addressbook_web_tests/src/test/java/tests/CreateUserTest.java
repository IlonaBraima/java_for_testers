package tests;

import model.UserData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CreateUserTest extends TestBase {

  public static List<UserData> userProvider() {
    var result = new ArrayList<UserData>();
    for (var firstName : List.of("", "firstName")) {
      for (var middleName : List.of("", "middleName")) {
        for (var lastName : List.of("", "lastName")) {
          for (var nickName : List.of("", "nickName")) {
            for (var title : List.of("", "title")) {
              for (var email : List.of("", "anoli@test.com"))
                result.add(new UserData(firstName, middleName, lastName, nickName, title, email));
              }
          }
        }
      }
    }
      for (int i = 0; i < 5; i++) {
        result.add(new UserData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10)));
      }
      return result;
    }

  @ParameterizedTest
  @MethodSource("userProvider")

  public void CanCreateMultipleUsers(UserData user) {
    int userCount = app.users().getCount();
    app.users().createUser(user);
    int newUserCount = app.users().getCount();
    Assertions.assertEquals(userCount + 1, newUserCount);
  }

  }



