package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects1.ForgotPasswordObject;
import pageObjects1.LandingPage1;
import pageObjects1.LoginPage1;
import resources.Base1;

import java.io.IOException;

public class TestHomePage extends Base1 {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base1.class.getName());

    @BeforeTest
    public void initilizing() throws IOException, InterruptedException {
        driver = initilizeDriver();
        log.info("TestHomePage Driver is initialized ---2 ");
        }

    @Test(dataProvider = "getData")
    public void testHomePageLogin(String userEmail, String passwordUser, String text) throws IOException {
        driver.get(properties.getProperty("url"));
        log.info("TestHomePage navigate to home page ---2");
        LandingPage1 l = new LandingPage1(driver);
        l.getLogin().click();
//        LoginPage1 lP1 = l.getLogin();
        LoginPage1 lP1 = new LoginPage1(driver);
        lP1.getEmail().sendKeys(userEmail);
        lP1.getUserPassword().sendKeys(passwordUser);
        System.out.println("++++++++++++++---2++++++++++++++");

        log.info(text);

        lP1.getSubmitButton().click();
//        ============================
        ForgotPasswordObject fgo = lP1.getForogotPasswordObject();
        fgo.getEmailForgotPage().sendKeys("asd@sdf.com");
        fgo.sendMeInstructionForgotPage().click();


        System.out.println("Test testPageNavigationLogin ---2");


    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[1][3];
//        Object[][] data = new Object[2][3];
        data[0][0] = "nonorestrictedUser@user1.com";
        data[0][1] = "12tertertert3";
        data[0][2] = "resricted user ---2";

//        data[1][0]="restrictedUser@user2.com";
//        data[1][1] = "456";
//        data[1][2]="non resricted user ---2";
        return data;
    }


    @AfterTest
    public void teardown() {
        driver.close();
        driver=null;
    }

}
