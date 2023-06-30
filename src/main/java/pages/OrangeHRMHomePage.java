package pages;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public class OrangeHRMHomePage extends BasePage{

    //private final By profileDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By drpDwnProfile = By.className("oxd-userdropdown-name");
    private final By btnLogout = By.linkText("Logout");


    public OrangeHRMHomePage clickProfiles(){
        click(drpDwnProfile, WaitStrategy.PRESENCE);
        ExtentLogger.pass("Clicked On Profiles");
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
        click(btnLogout, WaitStrategy.PRESENCE);
        ExtentLogger.pass("Logout is done Successfully");
        return new OrangeHRMLoginPage();

    }


}
