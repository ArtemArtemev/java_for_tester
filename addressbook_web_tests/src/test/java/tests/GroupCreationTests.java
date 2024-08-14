package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("group name", "group futter", "group comment"));
    }

    @Test
    public void CanCreateWithEmptyGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData());
    }

    @Test
    public void CanCreateWithEmptyNameOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withName("some name"));
    }
}
