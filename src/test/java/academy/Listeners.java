package academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base1;
import resources.ExtendReporterNG;

import java.io.IOException;

public class Listeners extends Base1 implements ITestListener {
    ExtentReports extent = ExtendReporterNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        extentTest.get().log(Status.FAIL, "Test FAiL+");

        WebDriver driver = null;//для уточнения  драйвера, который Fail
        String testMethodName = result.getMethod().getMethodName();// вычленили имя Теста
        try {
            System.out.println("============testMethodName================");
            System.out.println(testMethodName);
            driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("driver")
                    .get(result.getInstance());// вычленили экземпляр драйвера


        } catch (Exception e) {
        }
        try {
            String pathScreen = getScreenShot(testMethodName, driver);
            extentTest.get().addScreenCaptureFromPath(pathScreen, result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
