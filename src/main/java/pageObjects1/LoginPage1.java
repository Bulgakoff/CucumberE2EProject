package pageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 {
    //attributes Class:
    public WebDriver driver;
    private By email = By.xpath("//input[@id='user_email']");
    private By userPassword = By.xpath("//input[@id='user_password']");
    private By submit = By.xpath("//input[@type='submit']");
    private By forgotPassword = By.xpath("//a[@class='link-below-button']");
    //constructor:
    public LoginPage1(WebDriver driver) {
        this.driver = driver;
    }
    //methods:
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getUserPassword() {
        return driver.findElement(userPassword);
    }
    public WebElement getSubmitButton() {
        return driver.findElement(submit);
    }
    public ForgotPasswordObject getForogotPasswordObject() {
        driver.findElement(forgotPassword).click();
        ForgotPasswordObject fgo = new ForgotPasswordObject(driver);
        return fgo;
    }



}
