package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact, ApplicationManager manager) {
        openContactPage();
        fillContact(contact);
        submitContactCreation();
        returnHomePage();
    }

    public void removeContact() {
        selectContact();
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
        click(By.name("new_group"));
        {
            WebElement dropdown = manager.driver.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath("//option[. = 'group namemodified name']")).click();
        }

    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }


    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }
}
