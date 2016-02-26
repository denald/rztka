package rozetka.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dlapin on 2/26/2016.
 */
public class EditableElement extends ClickableElement {

    public EditableElement(WebDriver driver, SearchBy elementSearchCriteria, String elementValue) {
        super(driver, elementSearchCriteria, elementValue);
    }

    public void type(final CharSequence text){
        type(text, true);
    }

    public void clearInput(){
        waitUntil(ExpectedConditions::elementToBeClickable).clear();
    }

    public void type(final CharSequence text, final boolean clear){
        if (clear){
            clearInput();
        }
        waitUntil(ExpectedConditions::elementToBeClickable).sendKeys(text);
    }
}
