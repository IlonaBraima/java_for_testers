package tests;

import org.junit.jupiter.api.Test;

public class CreateUserTest extends TestBase {

  @Test
  public void CanCreateUser() {
    app.users().createUser();
  }
}
