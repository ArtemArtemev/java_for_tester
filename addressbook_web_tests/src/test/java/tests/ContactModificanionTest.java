package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificanionTest extends TestBase{

    @Test
    void canModifyContact(){
        if(app.contacts().getCount() == 0){
            app.contacts().createContact(new ContactData().withfirstname("Maks"));
        }
        var oldContacts = app.hbm().getContactList();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        var testData = new ContactData().withfirstname("Max").withLastname("Dolohov");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContact = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index,testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);
    }
}

