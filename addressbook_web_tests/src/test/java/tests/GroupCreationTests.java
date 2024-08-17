package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupData("group name", "group futter", "group comment"));
    }

    @Test
    public void canCreateWithEmptyGroup() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateWithEmptyNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
