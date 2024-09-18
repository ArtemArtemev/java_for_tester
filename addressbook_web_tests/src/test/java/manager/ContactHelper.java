package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContact(contact);
        submitContactCreation();
        returnHomePage();
    }

    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContact();
    }

    public void openContactPage() {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }


    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContact(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        attach(By.name("photo"), contact.photo());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        click(By.name("bday"));
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '10']")).click();
        }
        click(By.name("bmonth"));
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'March']")).click();
        }
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys("2000");
        click(By.name("aday"));
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '12']")).click();
        }
        click(By.name("amonth"));
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'April']")).click();
        }
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys("2000");
//        click(By.name("new_group"));
//        {
//            WebElement dropdown = manager.driver.findElement(By.name("new_group"));
//            dropdown.findElement(By.xpath("//option[. selected[]]")).click();
//        }

    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }


    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactData contact) {

        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public int getCount() {

        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var entrys = manager.driver.findElements(By.name("entry"));
        for (var entry : entrys) {
            var checkbox = entry.findElement(By.cssSelector("input"));
            var id = checkbox.getAttribute("value");
            var lastName = entry.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var firstName = entry.findElement(By.cssSelector("td:nth-child(3)")).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withLastname(lastName)
                    .withfirstname(firstName));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData modifyContact) {
        getSelectModifyContact(contact);
        fillContact(modifyContact);
        getSaveContactModification();
        //returnHomePage();
    }

    private void getSaveContactModification() {
            click(By.name("update"));
    }

    private void getSelectModifyContact(ContactData contact) {
        var elementId = manager.driver.findElement(By.id(contact.id()));
        var entry = elementId.findElement(By.xpath("../.."));
        var editButton = entry.findElement(By.cssSelector("td:nth-child(8)"));
        editButton.click();
    }
}
