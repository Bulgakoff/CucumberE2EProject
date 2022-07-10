package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base1 {
    public static WebDriver driver;
    public Properties properties;

    public WebDriver initilizeDriver() throws IOException {
        properties = new Properties();
        FileInputStream fis =
                new FileInputStream
                        (System.getProperty("user.dir")
                                + "\\src\\main\\java\\resources\\data.properties");
        properties.load(fis);
        String browserName = properties.getProperty("browser");//for TestNG1.xml
//        String browserName = System.getProperty("browser"); //for console
        if (browserName.contains("chrome")) {
            //execute chrome driver chrome:
            System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriverjava\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
                driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {

        } else if (browserName.equals("IE")) {

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        //буфер(экземпляр источника) для файла из браузера (подготовка в локальный файл):
        File sourceObj = ts.getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        //буфер(экземпляр назначения) для файла из браузера (подготовка в локальный файл):
        File destinatioObj = new File(destinationFilePath);//тут пустой создается файл на локале
        FileUtils.copyFile(sourceObj, destinatioObj);// переливаем

        return destinationFilePath;

    }
}
