package tests;

import manager.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    public Properties properties;

    public PageManager pageManager;

    @BeforeClass
    public  void  init() throws IOException {

        //load project properties
        properties = Utils.loadProperties();

        System.setProperty("webdriver.gecko.driver", properties.getProperty("driverpath"));
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        pageManager = new PageManager(driver);

        driver.get(properties.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        if(null != driver) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
