package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact(){
        if(app.contacts().getCount() == 0){
            app.contacts().createContact(new ContactData().withfirstname("Maks"));
        }
        var oldContacts = app.contacts().getList();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
