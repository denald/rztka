package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import rozetka.locators.interfaces.ILocator;

public class ClickableElement extends HTMLElement {



    public ClickableElement(final WebDriver driver, final ILocator elementLocator){
        super(driver, elementLocator);
    }

    public void click(){
        waitUntil(ExpectedConditions::elementToBeClickable).click();
        Reporter.log(String.format("[INFO] - Clicked '%s'", this.getElementName() ));
    }

    public String getText(){
        Reporter.log(String.format("[INFO] - Getting text of '%s'", this.getElementName() ));
        return waitUntil(ExpectedConditions::elementToBeClickable).getText();
    }


}
