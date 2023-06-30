package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReporter;

public class TestListener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReporter.initReport();

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReporter.createTestCase(result.getName());
        ExtentLogger.info("Test Description: "+result.getMethod().getDescription());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " : Test Executed Successfully");


    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()),false);


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //No Test case is skipped as of now

    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReporter.tearDownReport();

    }
}
