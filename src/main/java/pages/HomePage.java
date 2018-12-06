package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;


    @FindBy(id="menu")
    private WebElement profile;

    @FindBy(id="post")
    private WebElement post;

    @FindBy(id = "profilebutton")
    private WebElement profileButton;





    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }


    public String getContent()
    {
        return driver.getCurrentUrl();
    }



    public ProfilePage goToProfilePage() throws InterruptedException {
        profile.click();
        profileButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/accountSettings"));
        return PageFactory.initElements(driver, ProfilePage.class);
    }

    public PostItemPage goToPostItem() throws InterruptedException {
        post.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/postitems"));
        return PageFactory.initElements(driver, PostItemPage.class);
    }


}
