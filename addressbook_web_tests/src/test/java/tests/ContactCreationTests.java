package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider(){
        var result = new ArrayList<ContactData>();
        result.add(new ContactData()
                        .withfirstname(randomString(5)).withMiddlename(randomString(5)).withLastname(randomString(5))
                        .withNickname(randomString(5)).withTitle(randomString(5)).withCompany(randomString(5))
                        .withAddress(randomString(5)).withHome(randomInt(6)).withMobile("+7" + randomInt(10)).withWork(randomInt(6))
                        .withFax(randomInt(6)).withEmail(randomString(5) + "@list.ru").withEmail2(randomString(5) + "@list.ru")
                        .withEmail3(randomString(5) + "@list.ru").withHomepage(randomString(5)));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateContact(ContactData contact) {
        var oldContact = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContact = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);

        var expectedList = new ArrayList<>(oldContact);
        expectedList.add(contact.withId(newContact.get(newContact.size() - 1).id()).withMiddlename("").withNickname("").withTitle("").withCompany("").withAddress("")
                .withHome("").withMobile("").withWork("").withFax("").withFax("").withEmail("").withEmail2("").withEmail3("").withHomepage(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact, expectedList);
    }

}
