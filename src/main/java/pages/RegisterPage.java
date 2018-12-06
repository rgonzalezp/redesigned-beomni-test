package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage
{

    private WebDriver driver;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "firstName")
    private WebElement firstBox;

    @FindBy(id = "lastName")
    private WebElement lastBox;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "logout")
    private WebElement logoutButton;



    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage registerSuccess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        registerButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        emailBox.sendKeys("rikeyjo"+ Math.floor(Math.random()*100)+"123@gmail.com");
        firstBox.sendKeys("Ricardo ");
        lastBox.sendKeys("Gonzalez");
        passwordBox.sendKeys("123456");

        submitButton.click();
        wait.until(ExpectedConditions.urlContains("/results"));
        return PageFactory.initElements(driver, HomePage.class);
    }



}
