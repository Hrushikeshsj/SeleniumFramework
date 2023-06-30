package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import enums.BaseConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ReadPropertyFile;

public final class ExtentLogger {
    private ExtentLogger(){};


    public static void pass(String message){
        ExtentReportManager.getExtentTest().pass(message);
    }
    public static void info(String info){
        ExtentReportManager.getExtentTest().info(info);
    }
    public static void skip(String info){
        ExtentReportManager.getExtentTest().skip(info);
    }
    public static void fail(String reason){
        ExtentReportManager.getExtentTest().fail(reason);
    }


    public static void pass(String message,boolean isPassedTcScreenshotRequired){
        if(ReadPropertyFile.getPropertyValue(BaseConfig.ISPASSEDTCSCREENSHOTREQUIRED).equalsIgnoreCase("yes")
        &&isPassedTcScreenshotRequired){
            ExtentReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }else {
            pass(message);
        }

    }
    public static void fail(String message,boolean isFailedTcScreenshotRequired){
        if(ReadPropertyFile.getPropertyValue(BaseConfig.ISFAILEDTCSCREENSHOTREQUIRED).equalsIgnoreCase("yes")
                &&isFailedTcScreenshotRequired){
            ExtentReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }else {
            fail(message);
        }

    }

    private static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }


}
