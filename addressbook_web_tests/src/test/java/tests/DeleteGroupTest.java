import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroup() {
        app.openGroupPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("group name", "group header", "group footer"));
        }
        removeGroup();
    }

    private static void removeGroup() {
        ApplicationManager.driver.findElement(By.name("selected[]")).click();
        ApplicationManager.driver.findElement(By.name("delete")).click();
        ApplicationManager.driver.findElement(By.linkText("group page")).click();
    }

}

