package tests.Register;

import helpers.JUnitRunnerHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterSuccess extends JUnitRunnerHelper {


    @Test
    public void successRegister() throws InterruptedException {
        RegisterPage registerPage = PageFactory.initElements(driver.getDriver(), RegisterPage.class);
        HomePage homePage = registerPage.registerSuccess();

        String expectedState = homePage.getContent();


        MatcherAssert.assertThat("Didn't navigate properly to the search page",expectedState,Matchers.containsString("results"));

    }
}
