package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextElement extends HTMLElement {

    public TextElement(WebDriver driver, By elementLocator) {
        super(driver, elementLocator);
    }

    public String getText(){
        return waitUntil(ExpectedConditions::visibilityOfElementLocated).getText();
    }
}
