package reports;
import com.aventstack.extentreports.ExtentTest;


public final class ExtentReportManager {
    private ExtentReportManager(){};

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return test.get();
    }

    static void setExtentTest(ExtentTest newTest) {
        test.set(newTest);

    }
    public static void UnloadReportThread(){
        test.remove();
    }
}
