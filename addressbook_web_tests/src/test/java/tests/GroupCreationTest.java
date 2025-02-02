import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.openGroupPage();
        app.createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.openGroupPage();
        app.createGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.openGroupPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }

}
