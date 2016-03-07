package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import rozetka.locators.interfaces.ILocator;


public class EditableElement extends ClickableElement {

    public EditableElement(final WebDriver driver, final ILocator elementLocator) {
        super(driver, elementLocator);
    }
    public void sendKeys(final CharSequence text  ){
        clearInput();
        waitUntil(ExpectedConditions::elementToBeClickable).sendKeys(text);
        Reporter.log(String.format("[INFO] - Typed '%s' in '%s'" , text, this.getElementName()));
    }
    public void clearInput(){
        waitUntil(ExpectedConditions::elementToBeClickable).clear();
    }

}
