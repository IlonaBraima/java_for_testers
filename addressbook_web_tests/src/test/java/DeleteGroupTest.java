import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroup() {
        openGroupPage();
        if (!isGroupPresent()) {
            createGroup(new GroupData("group name", "group header", "group footer"));
        }
        removeGroup();
    }

    private static void removeGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }

}

