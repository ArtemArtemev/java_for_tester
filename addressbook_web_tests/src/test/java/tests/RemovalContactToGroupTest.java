package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class RemovalContactToGroupTest extends TestBase{

    @Test
    public void removalContactToGroup(){
        if(app.hbm().getGroupCount() == 0){
            app.hbm().createGroup(new GroupData("", "group name", "group futter", "group comment"));
        }
        if(app.contacts().getCount() == 0){
            app.contacts().createContact(new ContactData().withfirstname("Maks"));
        }

        var group = app.hbm().getGroupList().get(0);
        var contact = app.hbm().getContactList().get(0);

        var oldRelated = app.hbm().getContactInGroup(group);

        if(oldRelated.size() == 0){
            app.contacts().addContact(contact, group);
            oldRelated = app.hbm().getContactInGroup(group);
        }
        var random = new Random();
        var index = random.nextInt(oldRelated.size());
        app.contacts().removeContactInGroup(oldRelated.get(index), group);
        var newRelated = app.hbm().getContactInGroup(group);

        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(contact);
        Assertions.assertEquals(newRelated, expectedList);
    }
}
