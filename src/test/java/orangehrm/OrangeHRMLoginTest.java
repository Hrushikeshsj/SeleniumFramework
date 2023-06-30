package orangehrm;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import tests.BaseTest;

import java.util.Map;

public class OrangeHRMLoginTest extends BaseTest {

    @Test(dataProvider ="getLoginData",dataProviderClass = dataproviders.OHRMDataProvider.class)
    public void loginLogoutTest(Map<String,String> data){

        OrangeHRMLoginPage orlp = new OrangeHRMLoginPage();
        String title = orlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfiles().clickLogout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Page Title is Blank").isNotBlank()
                .as("Page Title is not Expected Null").isNotNull()
                .isEqualToIgnoringCase("OrangeHRM");

    }


    @Test(dataProvider ="getLoginData",dataProviderClass = dataproviders.OHRMDataProvider.class)
    public void newTest(Map<String,String> data){

        OrangeHRMLoginPage orlp = new OrangeHRMLoginPage();
        String title = orlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfiles().clickLogout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Page Title is Blank").isNotBlank()
                .as("Page Title is not Expected Null").isNotNull()
                .isEqualToIgnoringCase("OrangeHRM");

    }

}
