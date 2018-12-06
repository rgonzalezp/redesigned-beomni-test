package tests.Profile;

import helpers.JUnitRunnerHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class profileChange extends JUnitRunnerHelper {


    private HomePage homePage;

    @Before
    public void setup() throws InterruptedException {
        //precondition
        LoginPage loginPage = PageFactory.initElements(driver.getDriver(), LoginPage.class);
        homePage = loginPage.loginSuccess();
    }

    @Test
    public void changeInfo() throws InterruptedException {


        ProfilePage profilePage = homePage.goToProfilePage();
        String actual = "ricardo"+ Math.floor(Math.random()*100);
        String res = profilePage.makeAChange(actual);

        MatcherAssert.assertThat("Didn't make the change we wanted",actual,Matchers.comparesEqualTo(res));

    }


}
