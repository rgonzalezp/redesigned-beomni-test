package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class SweetDriverFacade  {

    private WebDriver driver;

    private String userName;
    private String password;

    public SweetDriverFacade(WebDriver driver) {
        this.driver = driver;
    }

    public SweetDriverFacade(WebDriver driver, String userName, String password) {
        this.driver = driver;
        this.userName = userName;
        this.password = password;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void get(String url)
    {
        driver.get(url);
    }
    public void quit()
    {
        driver.quit();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
