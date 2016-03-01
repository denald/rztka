package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dlapin on 3/1/2016.
 */
public class Button extends ClickableElement {
    public Button(WebDriver driver, By elementLocator) {
        super(driver, elementLocator);
    }
}
