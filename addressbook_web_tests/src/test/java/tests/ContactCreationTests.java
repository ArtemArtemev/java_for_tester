package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateContact(ContactData contact) {
        var oldContact = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContact = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        var maxId = newContact.get(newContact.size() - 1).id();

        var expectedList = new ArrayList<>(oldContact);
        expectedList.add(contact.withId(maxId).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);
    }

}
