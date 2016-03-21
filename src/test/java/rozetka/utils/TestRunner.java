package rozetka.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import rozetka.pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by dlapin on 2/24/2016.
 */
public class TestRunner {
    protected WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
