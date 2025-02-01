import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void CanCreateGroup() {
        openGroupPage();
        createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupPage();
        createGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        openGroupPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }

}
