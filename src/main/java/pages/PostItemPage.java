package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostItemPage {

    private WebDriver driver;

    @FindBy(id="title")
    private WebElement nameBox;

    @FindBy(id = "price")
    private WebElement priceBox;

    @FindBy(id = "submit")
    private WebElement submitButton;



    public PostItemPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String makeAPost()
    {



        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitchange")));
        nameBox.sendKeys("Carrito");
        priceBox.sendKeys("5");
        submitButton.click();

        return "";

    }



}
