package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox extends EditableElement {

    public TextBox(WebDriver driver, By elementLocator) {
        super(driver, elementLocator);
    }
}
