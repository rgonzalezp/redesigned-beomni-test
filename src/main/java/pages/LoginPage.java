package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{

    private WebDriver driver;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "username")
    private WebElement usernameBox;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "logout")
    private WebElement logoutButton;



    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage loginSuccess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        usernameBox.sendKeys("rikeyjo@gmail.com");
        passwordBox.sendKeys("123456");
        submitButton.click();
        wait.until(ExpectedConditions.urlContains("/results"));
        return PageFactory.initElements(driver, HomePage.class);
    }


    public HomePage logoutSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        usernameBox.sendKeys("rikeyjo@gmail.com");
        passwordBox.sendKeys("123456");
        submitButton.click();
        wait.until(ExpectedConditions.urlContains("/results"));
        logoutButton.click();
        wait.until(ExpectedConditions.urlContains("/login"));
        return PageFactory.initElements(driver, HomePage.class);
    }
}
