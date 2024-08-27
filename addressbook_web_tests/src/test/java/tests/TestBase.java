package tests;

import manager.ApplicationManager;
import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));
    }

    public static String randomString(int n){
       var rnd = new Random();
      var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomInt(int k){
        var rnd = new Random();
        var result = "";
        for (int i = 0; i <= k; i++) {
            result = result + rnd.nextInt(10);
        }
        return result;
    }
}
