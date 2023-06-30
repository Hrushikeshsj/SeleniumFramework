package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReporter {
    private ExtentReporter(){};

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports.html");

    public static void initReport(){
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void createTestCase(String TestName){
        ExtentTest test = extent.createTest(TestName);
        ExtentReportManager.setExtentTest(test);

    }

    public static void tearDownReport(){
        extent.flush();
        ExtentReportManager.UnloadReportThread();
    }


}
