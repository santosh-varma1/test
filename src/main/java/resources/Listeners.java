package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReporterNG;

import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test-Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test failed- starting onTestFailure");
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        //Screenshot
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        String methodName = result.getMethod().getMethodName();


        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodName, driver), result.getMethod().getMethodName());
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
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}
