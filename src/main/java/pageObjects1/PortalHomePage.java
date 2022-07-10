package pageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
    //attributes Class:
    public WebDriver driver;
    private By searchBox = By.xpath("//input[@id='search-courses']");
    //constructor:
    public PortalHomePage(WebDriver driver) {
        this.driver = driver;
    }
    //methods:
    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }
}
