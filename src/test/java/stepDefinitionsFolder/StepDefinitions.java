package stepDefinitionsFolder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects1.LandingPage1;
import pageObjects1.LoginPage1;
import pageObjects1.PortalHomePage;
import resources.Base1;

import java.io.IOException;

public class StepDefinitions extends Base1 {
    public static Logger log = LogManager.getLogger(Base1.class.getName());

    @Given("^Initialize test with chrome$")
    public void initializeTestWithChrome() throws IOException {
        driver = initilizeDriver();
        log.info(" Driver is initialized by Cucumber tool ---2 ");
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigateToSite(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
    }

    @And("^Click on Login link in home page to land on Secure sign in page$")
    public void clickOnLoginLinkInHomePageToLandOnSecureSignInPage() {
        LandingPage1 l = new LandingPage1(driver);
        if (l.getPopuUpSize().size() > 0) {
            l.getPopup().click();
        }
        l.getLogin().click();
    }

    @When("^User enters the (.+) & (.+) and logs in$")
    public void user_enters_the_and_logs_in(String username, String password) {
        LoginPage1 lP1 = new LoginPage1(driver);
        lP1.getEmail().sendKeys(username);
        lP1.getUserPassword().sendKeys(password);
        System.out.println("++++++++++++++---2++++++++++++++");
        lP1.getSubmitButton().click();
        System.out.println("++++++++++++++---3+++++++++");
    }

    @Then("^Verify that user is successfully logged in$")
    public void verifyThatUserIsSuccessfullyLoggedIn() {
        PortalHomePage pp = new PortalHomePage(driver);
        System.out.println("++++++++++++++---verifyThatUserIsSuccessfullyLoggedIn 4++++++++++++++");
        Assert.assertTrue(pp.getSearchBox().isDisplayed());
    }

    @And("^close browser$")
    public void close_browser() {
        driver.quit();
    }
}
