package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class AddContactToGroupTest extends TestBase {

  @Test
  public void addContactToGroup() {
    if(app.hbm().getGroupCount() == 0){
      app.hbm().createGroup(new GroupData("", "group name", "group futter", "group comment"));
    }
    if(app.contacts().getCount() == 0){
      app.contacts().createContact(new ContactData().withfirstname("Maks"));
    }
    var group = app.hbm().getGroupList().get(0);

    var oldContacts = app.hbm().getContactList();
    var random = new Random();
    var index = random.nextInt(oldContacts.size());
    var oldRelated = app.hbm().getContactInGroup(group);
    app.contacts().addContact(oldContacts.get(index), group);
    var newRelated = app.hbm().getContactInGroup(group);
    var expectedList = new ArrayList<>(oldRelated);
    expectedList.add(oldContacts.get(index));
    Comparator<ContactData> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    expectedList.sort(compareById);
    Assertions.assertEquals(newRelated, expectedList);
  }
}
