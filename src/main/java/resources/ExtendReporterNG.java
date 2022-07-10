package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");// болванка создана

        extent = new ExtentReports();// attacher
        extent.attachReporter(reporter);//присоединили

        extent.setSystemInfo("Tester", "Alexey Bulgakov");// доп

        return extent;
    }
}
