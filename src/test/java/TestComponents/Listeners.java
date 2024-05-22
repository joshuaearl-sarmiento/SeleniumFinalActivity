package TestComponents;

import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal(); //Thread safe

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //Unique Thread-ID
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test PASSED");
        //Declares "driver" for screenshot
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //Screenshot and attach to the report
        String filePath = null;
        try {
            filePath = getPassedScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        //Declares "driver" for screenshot
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //Screenshot and attach to the report
        String filePath = null;
        try {
            filePath = getFailedScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//    }
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//    }
//    @Override
//    public void onStart(ITestContext context) {
//    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
