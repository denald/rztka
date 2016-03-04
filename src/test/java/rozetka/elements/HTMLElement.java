package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class HTMLElement extends By {

    protected By locator;
    protected WebDriverWait wait;

    private String elementValue;
//    private By elementLocator;

    private static final long DEFAULT_TIMEOUT = 5;


    public HTMLElement(final WebDriver driver, final By elementLocator){
        this.locator = elementLocator;
        if (driver != null){
            this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        }
    }

    public By getLocator(){
        return locator;
    }

    public String getElementValue(){
        return elementValue;
    }

    public String getAttribute(String attributeName){
        return waitUntil(ExpectedConditions::presenceOfElementLocated).getAttribute(attributeName);
    }

    public String getCssValue(String cssSetting){
        return waitUntil(ExpectedConditions::presenceOfElementLocated).getCssValue(cssSetting);
    }

    public Boolean isEnabled(){
        return waitUntil(ExpectedConditions::visibilityOfElementLocated).isEnabled();
    }

    public WebElement waitUntil(final Function<By, ExpectedCondition<WebElement>> condition){
        return waitUntil(condition, Optional.<Long>empty());
    }

    public WebElement waitUntil(final Function<By, ExpectedCondition<WebElement>> condition, final Optional<Long> timeout){
        try{
            return getWait(timeout).until(condition.apply(getLocator()));
        } catch (Exception e){
            throw new AssertionError("Unable to find element by " + getLocator() + " = \"" + getElementValue() + "\"", e);
        }
    }

    private FluentWait<WebDriver> getWait(final Optional<Long> timout){
        return timout.map(sec -> wait.withTimeout(sec, TimeUnit.SECONDS))
                .orElse(wait.withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS));
    }

    public List<WebElement> getAll(final WebDriver driver, final By elementLocator){
        return driver.findElements(elementLocator);
    }

    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        return new ArrayList<>();
    }
}
