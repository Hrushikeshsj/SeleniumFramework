package tests;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

    private HomePageTest(){};

    @Test
    public void test01(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);


    }

    @Test
    public void test02(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("WebDriver", Keys.ENTER);

    }
}
