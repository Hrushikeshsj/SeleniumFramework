package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory(){};

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();
    static {
        driverMap.put("EDGE",()->new EdgeDriver());
    }

    public static void getDriver(String Browser ){


    }



}
