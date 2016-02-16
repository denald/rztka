package rozetka.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dlapin on 2/11/2016.
 */
public class PersonalPage extends BasePage {


    @FindBy(id = "profile_signout")
    private WebElement signOutLink;


    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public void signOut(){
        signOutLink.click();
    }


}
