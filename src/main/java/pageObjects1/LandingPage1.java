package pageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage1 {
    //attributes Class:
    public WebDriver driver;
    private By signIng = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");

    private By titlePage = By.xpath("//h2[text()='Featured Courses']");
    private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
    //p[contains(text(),'Learn Hot ')]
    // Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..
    private By header = By.xpath("//p[contains(text(),'Learn Hot ')]");
    private By buttonInPopup = By.xpath("//button[text()='NO THANKS']");


    //constructor:
    public LandingPage1(WebDriver driver) {
        this.driver = driver;
    }


    //methods class:
    public WebElement getLogin() {
        return  driver.findElement(signIng);
    }
    public List<WebElement> getPopuUpSize() {
        return  driver.findElements(buttonInPopup);
    }

    public WebElement getPopup() {
        return driver.findElement(buttonInPopup);
    }

    public WebElement getTitlePageElement() {
        return driver.findElement(titlePage);
    }

    public WebElement getNavBarElement() {
        System.out.println("Trying to expose navigation bar === 3 ");
        return driver.findElement(navBar);
    }

    public WebElement getHeader2() {
        return driver.findElement(header);
    }


}
