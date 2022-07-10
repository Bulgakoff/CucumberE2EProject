package pageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordObject {
    public WebDriver driver;

    private By emailForgotPage = By.xpath("//input[@id='user_email']");
    //input[@name='commit']
    private By sendMeInstruction = By.xpath("//input[@name='commit']");


    public ForgotPasswordObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailForgotPage() {
        return driver.findElement(emailForgotPage);
    }
    public WebElement sendMeInstructionForgotPage() {
        return driver.findElement(sendMeInstruction);
    }

}
