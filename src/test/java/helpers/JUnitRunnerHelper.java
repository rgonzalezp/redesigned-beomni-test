package helpers;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JUnitRunnerHelper {
    protected  SweetDriverFacade driver;
    protected LoginPage homePage;


    @Before
    public  void beforeTest() throws IOException {

        System.setProperty("webdriver.chrome.drive","./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");


        String creds = readCredentials();
        String user = creds.split("/")[0];
        String password = creds.split("/")[1];
        driver = new SweetDriverFacade(new ChromeDriver(options),user,password);

        screenShotRule.setDriver(driver.getDriver());

        driver.get("http://192.168.1.104:3000/");

        homePage = PageFactory.initElements(driver.getDriver(), LoginPage.class);
    }

    @Rule
    public ScreenShotRule screenShotRule = new ScreenShotRule();


    public  String readCredentials() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("./src/test/resources/credentials.properties"));
        String userName = prop.getProperty("user");
        // Password should always be stored in the char array.
        String password = prop.getProperty("password");


        String credentials = userName+"/"+password;

        return credentials;
    }


}

