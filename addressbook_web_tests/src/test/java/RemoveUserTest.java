import org.junit.jupiter.api.Test;

public class RemoveUserTest extends TestBase{

  @Test
  public void CanRemoveUser() {
    openHomePage();
    if (!isUserListPresent()) {
      createUser();
    }
    openHomePage();
    removeUser();

    if (isAlertPresent()) {
      driver.switchTo().alert().accept();
    }
  }
}

