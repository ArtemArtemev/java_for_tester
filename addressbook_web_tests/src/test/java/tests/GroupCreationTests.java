package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {

        app.groups().createGroup(new GroupData("group name", "group futter", "group comment"));
    }

    @Test
    public void CanCreateWithEmptyGroup() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void CanCreateWithEmptyNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
