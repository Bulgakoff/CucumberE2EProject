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

public class TestValidateNavigationBar extends Base1 {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base1.class.getName());
    @BeforeTest
    public void initilizing() throws IOException {
        driver = initilizeDriver();
        log.info("TestValidateNavigationBar Driver is initialized  === 3 ");
        driver.get(properties.getProperty("url"));
        log.info("TestValidateNavigationBar  to home page  === 3");
    }
    @Test
    public void testNavigateBar(){


        LandingPage1 l = new LandingPage1(driver);
        Assert.assertTrue(l.getNavBarElement().isDisplayed());
        log.info("TestValidateNavigationBar successful isDisplayed assert === 3 ");
        System.out.println("Test testPageNavigationLogin === 3");


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }

}
