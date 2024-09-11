package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    //Selenium webDriver stuff:
    protected static WebDriver webDriver;
    protected static WebDriverWait webDriverWait;

    @BeforeClass
    public void SetupBeforeClass() {
        initBrowser(BrowserTypes.CHROME);
    }

    @AfterClass
    public void tearDownAfterClass() {
        webDriver.quit();
    }

    public enum BrowserTypes {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge");

        BrowserTypes(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    private WebDriver initWebDriverInstance(BrowserTypes browserTypes) {
        System.out.println("Chosen browser: " + browserTypes.getValue());
        WebDriver driver = null;
        switch (browserTypes.getValue().toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
        }
        return driver;
    }

    private void initBrowser(BrowserTypes browserTypes) {
        webDriver = initWebDriverInstance(browserTypes);
        webDriverWait = new WebDriverWait(webDriver, 10);

        webDriver.manage().window().maximize();
        webDriver.get("file://C:\\Users\\User\\Documents\\Automation projects\\ResolverTechnicalAssessment\\src\\main\\resources\\QE-index.html");
    }
}
