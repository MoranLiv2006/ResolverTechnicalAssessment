package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    public void onTestStart(ITestResult test) {
        System.out.println(" --- Starting Test: " + test.getName() + " --- ");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println(" --- Test: " + test.getName() + " Passed --- ");
    }

    public void onTestFailure(ITestResult test) {

        System.out.println(" --- Test: " + test.getName() + " Failed --- ");
        try {
            takeScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./SeleniumScreenshots/Screen.png"));
        System.out.println("Screenshot is captured at: " + file.getPath());

    }
}
