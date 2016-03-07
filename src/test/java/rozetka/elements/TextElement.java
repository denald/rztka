package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rozetka.locators.interfaces.ILocator;

public class TextElement extends HTMLElement {

    public TextElement(final WebDriver driver, final ILocator elementLocator) {
        super(driver, elementLocator);
    }

    public String getText(){
        return waitUntil(ExpectedConditions::visibilityOfElementLocated).getText();
    }
}
