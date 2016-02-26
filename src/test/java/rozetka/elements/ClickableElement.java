package rozetka.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dlapin on 2/26/2016.
 */
public class ClickableElement extends HTMLElement {

    public ClickableElement(final WebDriver driver, final SearchBy elementSearchCriteria, final String elementValue){
        super(driver, elementSearchCriteria, elementValue);
    }

    public void click(){
        waitUntil(ExpectedConditions::elementToBeClickable).click();
    }

}
