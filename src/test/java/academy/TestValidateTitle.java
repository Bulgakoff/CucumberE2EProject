package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects1.LandingPage1;
import resources.Base1;

import java.io.IOException;

public class TestValidateTitle extends Base1 {
    public WebDriver driver;
    LandingPage1 l;

    public static Logger log = LogManager.getLogger(Base1.class.getName());

    @BeforeTest
    public void initilizing() throws IOException{
        driver = initilizeDriver();
        log.info("TestValidateTitle Driver is initialized  ++++ 1");
        driver.get(properties.getProperty("url"));
        log.info("TestValidateTitle  to home page  ++++ 1");
    }

    @Test
    public void testTitle() {
        l = new LandingPage1(driver);
        Assert.assertEquals(l.getTitlePageElement().getText(), "FEATURED COURSES");
        log.info("TestValidateTitle  successful assert text ++++ 1");
        System.out.println("Test testPageNavigationLogin ++++ 1");
    }

    @Test
    public void validateHeader() {
//        l = new LandingPage1(driver);
        Assert.assertEquals(l.getHeader2().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
        log.info("Successfully validated Text message ++++ 1");
        System.out.println("tEST validateHeader completed ++++ 1");

    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }

}
