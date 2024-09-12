package Utilities;

import PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static Utilities.ManagePages.initPages;

public class Base {

    //Prefix of the tests html file location
    protected final String FILE_LOCATION_PREFIX = "file://";

    //Selenium webDriver stuff:
    protected static WebDriver webDriver;
    protected static WebDriverWait webDriverWait;

    //Web Page Objects:
    public static Test1 test1;
    public static Test2 test2;
    public static Test3 test3;
    public static Test4 test4;
    public static Test5 test5;

    @BeforeMethod
    public void baseSetupBeforeMethod() {
        initBrowser(BrowserTypes.CHROME);
        initPages();
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        webDriver.close();
    }

    @AfterClass
    public void tearDownAfterClass() {
        webDriver.quit();
    }

    private enum BrowserTypes {
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
            default:
                System.out.println("No such browser type");
        }
        return driver;
    }

    private void initBrowser(BrowserTypes browserTypes) {
        webDriver = initWebDriverInstance(browserTypes);
        webDriverWait = new WebDriverWait(webDriver, 15);
//        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15)); //Selenium 4 implementation

        webDriver.manage().window().maximize();
    }

    protected String getDataFromXmlFile(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./src/main/java/Utilities/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Error Reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }
}
