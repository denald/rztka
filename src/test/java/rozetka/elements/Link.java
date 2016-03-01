package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dlapin on 3/1/2016.
 */
public class Link extends ClickableElement {

    public Link(WebDriver driver, By elementLocator) {
        super(driver, elementLocator);
    }
}
