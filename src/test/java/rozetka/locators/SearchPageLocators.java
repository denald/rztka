package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;

public enum SearchPageLocators implements ILocator {

    SEARCH_RESULTS_TITLE_TEXT(
            "Search results title text",
            LocatorsType.BY_CLASS_NAME,
            "search-result-title-text"),
    SUBMIT_TO_WISHLIST_POPUP_BUTTON(
            "Submit to wishlist popup button",
            LocatorsType.BY_CLASS_NAME,
            "btn-link-i"
    ),
    CLOSE_WISHLIST_POPUP_ICON(
            "Close wishlist popup icon",
            LocatorsType.BY_CLASS_NAME,
            "popup-close"
    ),
    TITLES_ON_SEARCH_PAGE(
            "Titles on search page",
            LocatorsType.BY_CLASS_NAME,
            "g-i-list-title"
    ),
    REVIEWS_COUNT_LIST(
            "List of reviews count",
            LocatorsType.BY_CLASS_NAME,
            "g-rating-reviews"
    );


    private String name;
    private LocatorsType locatorsType;
    private String modifiedLocator;
    private String rawLocator;
    private By byLocator;


    SearchPageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
        this.name = name;
        this.locatorsType = locatorsType;
        this.rawLocator = rawLocator;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public SearchPageLocators modify(final String parameter){
        this.modifiedLocator = String.format(this.rawLocator, parameter);
        return this;
    }

    @Override
    public By getBy(){
        this.byLocator = this.locatorsType.getBy(this.rawLocator);
        return byLocator;
    }
}
