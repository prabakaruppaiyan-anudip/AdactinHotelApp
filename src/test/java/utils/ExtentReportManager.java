package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
        	String path = System.getProperty("user.dir")
        	        + "/reports/ExtentReport.html";
        	 new File(System.getProperty("user.dir") + "/reports").mkdirs();
            ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);
            reporter.config().setReportName("Adactin Automation Report");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
