package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider(){
        int n = 5;
        var result = new ArrayList<ContactData>();
        result.add(new ContactData(randomString(5), randomString(5), randomString(5), randomString(5), randomString(5), randomString(5),
                randomString(5), randomInt(6), "+7" + randomInt(10), randomInt(6), randomInt(6), randomString(5) + "@list.ru", randomString(5) + "@list.ru",
                randomString(5) + "@list.ru", randomString(5)));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateContact(ContactData contact) {
        app.contacts().createContact(contact);
    }

}
