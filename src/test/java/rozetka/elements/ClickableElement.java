package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickableElement extends HTMLElement {



    public ClickableElement(final WebDriver driver, final By elementLocator){
        super(driver, elementLocator);
    }

    public void click(){
        waitUntil(ExpectedConditions::elementToBeClickable).click();
    }

    public String getText(){
        return waitUntil(ExpectedConditions::elementToBeClickable).getText();
    }


}
