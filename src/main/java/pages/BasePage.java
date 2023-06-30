package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {


    protected void click(By locator, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).click();
    }

    protected void sendKeys(By locator, WaitStrategy waitStrategy, String value){
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).sendKeys(value);
    }

    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }




}
