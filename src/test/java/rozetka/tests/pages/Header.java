package rozetka.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dlapin on 2/12/2016.
 */
public class Header extends BasePage {

    @FindBy(id = "header_user_menu_parent")
    private WebElement logInLink;

    @FindBy (name = "login")
    private WebElement emailTextBox;

    @FindBy (name = "password")
    private WebElement passwordTextBox;

    @FindBy (name = "auth_submit")
    private WebElement loginButton;

    @FindBy (name = "text")
    private WebElement searchBar;

    @FindBy (name = "search-button")
    private WebElement searchButton;

    @FindBy (id = "wishlist")
    private WebElement wishListIcon;

    @FindBy (xpath = "//a[@name='close']")
    private WebElement closeConfirmEmailPopupLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    public String getLoginLinkText(){
        return logInLink.getText();
    }

    public void logOut(){
        logInLink.click();
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.signOut();
    }
    public void logInAs(String login, String password){
        String oldLinkText = getLoginLinkText();
        logInLink.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(login);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(logInLink,oldLinkText)));
        closeConfirmEmailPopupLink.click();
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
