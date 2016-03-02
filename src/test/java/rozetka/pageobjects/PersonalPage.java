package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import rozetka.elements.Link;
import rozetka.locators.PersonalPageLocators;

public class PersonalPage extends Header {

    final private Link signOutLink = new Link(driver, PersonalPageLocators.SIGN_OUT_LINK.getBy());

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public void signOut(){
        signOutLink.click();
    }


}