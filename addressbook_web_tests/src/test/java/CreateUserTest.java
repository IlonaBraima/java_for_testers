import org.junit.jupiter.api.Test;

public class CreateUserTest extends TestBase {

  @Test
  public void CanCreateUser() {
    openAddNewUserPage();
    createUser();
  }

}
