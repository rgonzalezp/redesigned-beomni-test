package tests.Post;

import helpers.JUnitRunnerHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.PostItemPage;
import pages.ProfilePage;

public class PostItem extends JUnitRunnerHelper {


    private HomePage homePage;

    @Before
    public void setup() throws InterruptedException {
        //precondition
        LoginPage loginPage = PageFactory.initElements(driver.getDriver(), LoginPage.class);
        homePage = loginPage.loginSuccess();
    }

    @Test
    public void changeInfo() throws InterruptedException {


        PostItemPage profilePage = homePage.goToPostItem();

        String res = profilePage.makeAPost();



    }


}
