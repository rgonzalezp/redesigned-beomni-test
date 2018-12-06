package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    @FindBy(id="newname")
    private WebElement newName;

    @FindBy(id = "actualname")
    private WebElement actualName;

    @FindBy(id="startchange")
    private WebElement startChange;

    @FindBy(id = "submitchange")
    private WebElement submitChange;

    public ProfilePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String makeAChange(String text)
    {


        startChange.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitchange")));
        newName.sendKeys(text);
        submitChange.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("actualname")));

        String newNameInput = actualName.getText();

    return newNameInput;

    }



}
