package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EditableElement extends ClickableElement {

    public EditableElement(WebDriver driver, By elementLocator) {
        super(driver, elementLocator);
    }
    public void sendKeys(final CharSequence text  ){
        clearInput();
        waitUntil(ExpectedConditions::elementToBeClickable).sendKeys(text);
    }
    public void clearInput(){
        waitUntil(ExpectedConditions::elementToBeClickable).clear();
    }

}
