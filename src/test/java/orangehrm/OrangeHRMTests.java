package orangehrm;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import tests.BaseTest;

public class OrangeHRMTests extends BaseTest {


    @Test
    public void loginLogoutTest(){

        OrangeHRMLoginPage orlp = new OrangeHRMLoginPage();
        String title = orlp.enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickProfiles().clickLogout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Page Title is Blank").isNotBlank()
                .as("Page Title is not Expected Null").isNotNull()
                .isEqualToIgnoringCase("OrangeHRM");

    }


    @Test
    public void newTest(){

        OrangeHRMLoginPage orlp = new OrangeHRMLoginPage();
        String title = orlp.enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickProfiles().clickLogout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Page Title is Blank").isNotBlank()
                .as("Page Title is not Expected Null").isNotNull()
                .isEqualToIgnoringCase("OrangeHRM");

    }


}
