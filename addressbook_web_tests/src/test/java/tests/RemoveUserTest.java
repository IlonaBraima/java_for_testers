import manager.ApplicationManager;
import org.junit.jupiter.api.Test;

public class RemoveUserTest extends TestBase{

  @Test
  public void CanRemoveUser() {
    app.openHomePage();
    if (!app.isUserListPresent()) {
      app.createUser();
    }
    app.openHomePage();
    app.removeUser();

    if (app.isAlertPresent()) {
      ApplicationManager.driver.switchTo().alert().accept();
    }
  }
}

