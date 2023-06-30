package tests;

import driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public final class LoginPageTest extends BaseTest{
    private LoginPageTest(){};

    @Test
    public void test03(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        Assertions.assertThat(title)
                .isNotBlank()
                .containsIgnoringCase("google search")
                .as("Title Does not Ends with Search")
                .endsWithIgnoringCase("search");

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));

        Assertions.assertThat(elements)
                .hasSize(9)
                .extracting(e->e.getText())
                .as("Link Test not found")
                .contains("Testing Mini Bytes");


    }


}
