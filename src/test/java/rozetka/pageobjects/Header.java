package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rozetka.elements.Button;
import rozetka.elements.Link;
import rozetka.elements.TextBox;
import rozetka.locators.HeaderLocators;

/**
 * Created by dlapin on 2/12/2016.
 */
public class Header <T> extends BasePage {

    private Link logInLink = new Link(driver, HeaderLocators.LOGIN_LINK.getBy());
    private TextBox emailTextBox = new TextBox(driver, HeaderLocators.EMAIL_TEXT_BOX.getBy());
    private TextBox passwordTextBox = new TextBox(driver, HeaderLocators.PASSWORD_TEXT_BOX.getBy());
    private Button loginButton = new Button(driver, HeaderLocators.LOGIN_BUTTON.getBy());
    private TextBox searchBar = new TextBox(driver, HeaderLocators.SEARCH_BAR_TEXT_BOX.getBy());
    private Button searchButton = new Button(driver, HeaderLocators.SEARCH_BUTTON.getBy());
    private Button wishlistIcon = new Button(driver, HeaderLocators.WISHLIST_ICON.getBy());
    private Link closeConfirmEmailPopupLink = new Link(driver, HeaderLocators.CLOSE_CONFIRMATION_POPUP_LINK.getBy());
    private Link signOutLink = new Link(driver, HeaderLocators.SIGNOUT_LINK.getBy());

    public Header(WebDriver driver) {
        super(driver);
    }

    public String getLoginLinkText(){
        return logInLink.getText();
    }

    public void logOut(){

        Actions action = new Actions(driver);
        action.moveToElement(logInLink).perform();
        if (isElementPresent(signOutLink)) signOutLink.click();
    }

    public Header logInAs(String login, String password){
        String oldLinkText = getLoginLinkText();
        logInLink.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(login);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(logInLink,oldLinkText)));
        if (isElementPresent(closeConfirmEmailPopupLink)) closeConfirmEmailPopupLink.click();
        return new Header(this.driver);
    }

    public void clickOnSearchBar(){
        searchBar.click();
    }

    public Boolean searchButtonIsDisplayed(){
        return searchButton.isDisplayed();
    }

    public SearchPage searchFor(String keyword){
        searchBar.clear();
        searchBar.sendKeys(keyword);
        searchButton.click();
        if (isElementPresent(closeConfirmEmailPopupLink))
        {
            closeConfirmEmailPopupLink.click();
        }
        return new SearchPage(driver);
    }

    public WishListPage goToWishList(){
        wishListIcon.click();
        return new WishListPage(driver);
    }


}
