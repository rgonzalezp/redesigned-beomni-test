package tests.Login;

import helpers.JUnitRunnerHelper;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LoginSuccess extends JUnitRunnerHelper {


    @Test
    public void successLogin() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver.getDriver(), LoginPage.class);
        HomePage homePage = loginPage.loginSuccess();

        String expectedState = homePage.getContent();


        MatcherAssert.assertThat("Didn't navigate properly to the search page",expectedState,Matchers.containsString("results"));

    }
}
