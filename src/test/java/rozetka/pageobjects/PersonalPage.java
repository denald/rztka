package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import rozetka.elements.Link;
import rozetka.locators.PersonalPageLocators;

public class PersonalPage extends BasePage {

    final private Link signOutLink = new Link(driver, PersonalPageLocators.SIGN_OUT_LINK);

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public void signOut(){
        signOutLink.click();
    }


}
