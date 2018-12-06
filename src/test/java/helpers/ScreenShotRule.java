package helpers;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotRule extends TestWatcher {
    private WebDriver browser;

    public ScreenShotRule() {

    }

    public void setDriver(WebDriver driver){this.browser=driver;}

    @Override
    protected void failed(Throwable e, Description description) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;

        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = getDestinationFile();
        try {
            FileUtils.copyFile(scrFile, destFile);
            browser.quit();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void succeeded(Description description) {browser.quit();
    }
    @Override
    protected void finished(Description description) {
        browser.quit();
    }

    private File getDestinationFile() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY_hh_mm_ss_SS");
        String userDirectory = "C:\\Users\\rgonzalez\\repositories\\reactangularetc-automation-challenge\\screenshot";
        String fileName = "screenShotFailure"+dateFormat.format(new Date())+".png";
        String absoluteFileName = userDirectory + "/" + fileName;

        return new File(absoluteFileName);
    }
}
