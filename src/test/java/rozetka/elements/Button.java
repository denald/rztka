package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rozetka.locators.interfaces.ILocator;

/**
 * Created by dlapin on 3/1/2016.
 */
public class Button extends ClickableElement {
    public Button(final WebDriver driver, final ILocator elementLocator) {
        super(driver, elementLocator);
    }
}
