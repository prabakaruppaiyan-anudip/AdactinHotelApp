package listeners;

import org.testng.*;
import com.aventstack.extentreports.*;
import utils.ExtentReportManager;

public class TestListener implements ITestListener {
	

    ExtentReports extent = ExtentReportManager.getReportInstance();
    ExtentTest test;
    public TestListener() {
        System.out.println("TEST LISTENER CONSTRUCTOR CALLED");
    }


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {
    	System.out.println("EXTENT FLUSH CALLED");
        extent.flush();
    }
}
