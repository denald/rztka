package rozetka.pageobjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import rozetka.locators.interfaces.ILocator;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    protected WebDriver driver;

    public BasePage (final WebDriver driver){
        this.driver = driver;
    }
    public List<WebElement> getAll(By byLocator){
        return this.driver.findElements(byLocator);
    }

    public void refresh(final WebDriver driver){
        driver.navigate().refresh();
    }

    public void back(final WebDriver driver){
        driver.navigate().back();
    }

    public void forward(final WebDriver driver){
        driver.navigate().forward();
    }

    public void moveToElement(By elementBy){
        Actions action = new Actions(this.driver);
        action.moveToElement(this.driver.findElement(elementBy)).build().perform();
    }

    public boolean isElementPresent(By elementBy){
        try {
            return this.driver.findElement(elementBy).isDisplayed();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //return true;
        } catch (NoSuchElementException e) {
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return false;
        }

//        return driver.findElements(elementBy).size() != 0;
    }
}

