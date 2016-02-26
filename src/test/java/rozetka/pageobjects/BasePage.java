package rozetka.pageobjects;
import org.openqa.selenium.*;
import rozetka.locators.interfaces.ILocator;


public class BasePage {

    protected WebDriver driver;

    public BasePage (final WebDriver driver){
        this.driver = driver;
    }

    public void click(final ILocator locator){
        driver.findElement(locator.getBy()).click();
    }

    public boolean isElementDisplayed(final ILocator locator){
        return driver.findElements(locator.getBy()).size() != 0;
    }

}