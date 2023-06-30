package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public class OrangeHRMLoginPage extends BasePage {

    private final By txtBoxUserName = By.name("username");
    private final By txtBoxPassword =By.name("password");
    private final By btnLogin = By.xpath("//button[contains(@class,'oxd-button oxd-button--medium')]");


    public OrangeHRMLoginPage enterUserName(String username){
        sendKeys(txtBoxUserName, WaitStrategy.CLICKABLE,username);
        ExtentLogger.pass("Username Entered.");

        return this;
    }

    public OrangeHRMLoginPage enterPassword(String pass){
        sendKeys(txtBoxPassword, WaitStrategy.CLICKABLE,pass);
        ExtentLogger.pass("Password Entered.",false);
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        click(btnLogin, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Login is done Successfully");
        return new OrangeHRMHomePage();

    }




}
