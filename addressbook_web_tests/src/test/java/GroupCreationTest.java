import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void CanCreateGroup() {
        openGroupPage();
        createGroup("group name", "group header", "group footer");
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        createGroup("", "", "");
    }
}
