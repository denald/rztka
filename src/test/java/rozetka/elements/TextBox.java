package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rozetka.locators.interfaces.ILocator;

public class TextBox extends EditableElement {

    public TextBox(final WebDriver driver, final ILocator elementLocator) {
        super(driver, elementLocator);
    }
}
