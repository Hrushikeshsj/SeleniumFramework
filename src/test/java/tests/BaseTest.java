package tests;

import driver.Driver;
import enums.Drivers;
import exceptions.DriverInvocationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class BaseTest {

    protected BaseTest(){};

    @BeforeMethod
    protected void setUp(Object[] data){
        setupCustomBrowser(data);
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }

    protected void setupCustomBrowser(Object[] data){
        Map<String, String> TestData = (Map<String, String>) data[0];
        try {
            Driver.initCustomRemoteDriver(TestData.get("browser"));
        } catch (MalformedURLException e) {
            throw new DriverInvocationException("can not instantiate driver instance");
        }

    }
    protected void setupBrowser(){
        Driver.initDriver();

    }

}
