package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTest extends TestBase{

    @Test
    void canModifyGroup() {
        if(app.groups().getCount() == 0){
            app.groups().createGroup(new GroupData("group name", "group futter", "group comment"));
        }
        app.groups().modifyGroup(new GroupData().withName("some name"));
    }
}
