package driver;

import com.google.common.util.concurrent.Uninterruptibles;
import enums.BaseConfig;
import enums.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.*;
import reports.ExtentLogger;
import utilities.ReadPropertyFile;
import static driver.DriverManager.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
        //Private Constructor
    };


    public static void initDriver(){
        if(Objects.isNull(getDriver())){
            setDriver(new EdgeDriver());
            getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(getDriver())){
            getDriver().quit();
            unload();
        }
    }

    public static void initCustomDriver(String driverName){
        if(Objects.isNull(getDriver())){
            if (driverName.equalsIgnoreCase((Drivers.EDGE).toString())){
                WebDriverManager.chromiumdriver().setup();
                setDriver(new EdgeDriver());
                getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));

            } else if (driverName.equalsIgnoreCase((Drivers.CHROME).toString())) {
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));

            }else {
                ExtentLogger.info("Driver is not configured to run the Tests..Running Tests in Default Browser - Edge");
                setDriver(new EdgeDriver());
                getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));
            }

        }
    }

    public static void initCustomRemoteDriver(String driverName) throws MalformedURLException {
        String runmode = ReadPropertyFile.getPropertyValue(BaseConfig.RUNMODE);

        if(Objects.isNull(getDriver())){
            if (driverName.equalsIgnoreCase((Drivers.EDGE).toString())){
                if(runmode.equalsIgnoreCase("remote")){
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(Browser.EDGE.browserName());
                    setDriver(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),cap));
                    Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
                    getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));

                } else {
                    WebDriverManager.edgedriver().setup();
                    setDriver(new EdgeDriver());
                    getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));
                }

            } else if (driverName.equalsIgnoreCase((Drivers.CHROME).toString())) {
                if(runmode.equalsIgnoreCase("remote")){
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(Browser.CHROME.browserName());
                    setDriver(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),cap));
                    Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
                    getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));

                } else {
                    WebDriverManager.chromiumdriver().setup();
                    setDriver(new ChromeDriver());
                    getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));
                }

            }else {
                ExtentLogger.info("Driver is not configured to run the Tests..Running Tests in Default Browser - Edge");
                setDriver(new EdgeDriver());
                getDriver().get(ReadPropertyFile.getPropertyValue(BaseConfig.URL));
            }

        }
    }


}
