package tests.Logout;

import helpers.JUnitRunnerHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;

public class LogoutSuccess extends JUnitRunnerHelper {


    @Test
    public void successLogout() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver.getDriver(), LoginPage.class);
        HomePage homePage = loginPage.logoutSuccess();

        String expectedState = homePage.getContent();


        MatcherAssert.assertThat("Didn't navigate properly to the search page",expectedState,Matchers.containsString("login"));

    }
}
