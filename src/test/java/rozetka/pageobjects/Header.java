package rozetka.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rozetka.elements.*;
import rozetka.locators.HeaderLocators;

public class Header <T> extends BasePage {

    private Link logInLink = new Link(driver, HeaderLocators.LOGIN_LINK);
    private TextBox emailTextBox = new TextBox(driver, HeaderLocators.EMAIL_TEXT_BOX);
    private TextBox passwordTextBox = new TextBox(driver, HeaderLocators.PASSWORD_TEXT_BOX);
    private Button loginButton = new Button(driver, HeaderLocators.LOGIN_BUTTON);
    private TextBox searchBar = new TextBox(driver, HeaderLocators.SEARCH_BAR_TEXT_BOX);
    private Button searchButton = new Button(driver, HeaderLocators.SEARCH_BUTTON);
    private Button wishListIcon = new Button(driver, HeaderLocators.WISHLIST_ICON);
    private Link closeConfirmEmailPopupLink = new Link(driver, HeaderLocators.CLOSE_CONFIRMATION_POPUP_LINK);
    private Link signOutLink = new Link(driver, HeaderLocators.SIGNOUT_LINK);


    public Header(WebDriver driver) {
        super(driver);
    }

    public String getLoginLinkText(){
        return logInLink.getText();
    }

    public void logOut(){
        logInLink.click();
        if (isElementPresent(signOutLink.getLocator())){
            signOutLink.click();
        }

    }

    public Header logInAs(String login, String password){
        String oldLinkText = getLoginLinkText();
        logInLink.click();
        emailTextBox.sendKeys(login);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(logInLink.getLocator(), oldLinkText)));
        if (isElementPresent(closeConfirmEmailPopupLink.getLocator())) {
            closeConfirmEmailPopupLink.click();
        }
        return this;
    }

    public void clickOnSearchBar(){
        searchBar.click();
    }

    public Boolean searchButtonIsDisplayed(){
        return isElementPresent(searchButton.getLocator());
    }

    public SearchPage searchFor(String keyword){
        searchBar.click();
        searchBar.sendKeys(keyword);
        searchButton.click();
        if (isElementPresent(closeConfirmEmailPopupLink.getLocator()))
        {
            closeConfirmEmailPopupLink.click();
        }
        return new SearchPage(this.driver);
    }

    public WishListPage goToWishList(){
        wishListIcon.click();
        return new WishListPage(driver);
    }


    public void closePushNotificationPanel() {
        if (isElementPresent(By.className("notificationPanelBlock"))){
            driver.findElement(By.className("notificationPanelBlock")).click();
        }
    }
}
