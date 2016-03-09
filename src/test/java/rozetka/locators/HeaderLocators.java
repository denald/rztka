package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;

public enum HeaderLocators implements ILocator {

    LOGIN_LINK(
            "Login link",
            LocatorsType.BY_ID,
            "header_user_menu_parent"
    ),
    EMAIL_TEXT_BOX(
            "Email text box",
            LocatorsType.BY_XPATH,
            "//input[@name='login']"
    ),
    PASSWORD_TEXT_BOX(
            "Password text box",
            LocatorsType.BY_NAME,
            "password"
    ),
    LOGIN_BUTTON(
            "Login button",
            LocatorsType.BY_NAME,
            "auth_submit"
    ),
    SEARCH_BAR_TEXT_BOX(
            "Search bar text box",
            LocatorsType.BY_NAME,
            "text"
    ),
    SEARCH_BUTTON(
            "Search button",
            LocatorsType.BY_NAME,
            "search-button"
    ),
    WISHLIST_ICON(
            "Wishlist icon",
            LocatorsType.BY_ID,
            "wishlist"
    ),
    CLOSE_CONFIRMATION_POPUP_LINK(
            "Close confirmation pop up link",
            LocatorsType.BY_XPATH,
            "//a[@name='close']"
    ),
    SIGNOUT_LINK(
            "Sign out link",
            LocatorsType.BY_NAME,
            "signout"
    ),
    WISHLIST_COUNT_ICON(
            "Wishlist count icon",
            LocatorsType.BY_CLASS_NAME,
            "hub-i-count"
    );

    private String name;
    private LocatorsType locatorsType;
    private String rawLocator;
    private By byLocator;

    HeaderLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
        this.name = name;
        this.locatorsType = locatorsType;
        this.rawLocator = rawLocator;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public By getBy() {
        this.byLocator = this.locatorsType.getBy(this.rawLocator);
        return this.byLocator;
    }
}
