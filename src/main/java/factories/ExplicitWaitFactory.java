package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  final class  ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator){
        WebElement element = null;

        if(waitStrategy==WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getDEFAULTWAIT())
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (waitStrategy==WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getDEFAULTWAIT())
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy==WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getDEFAULTWAIT())
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }else if (waitStrategy==WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(locator);
        }

        return element;
    }




}
