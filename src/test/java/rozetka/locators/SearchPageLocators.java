package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;

public enum SearchPageLocators  implements ILocator {

    SEARCH_RESULTS_TITLE_TEXT(
            "Search results title text",
            LocatorsType.BY_CLASS_NAME,
            "(search-result-title-text)") ;


    private String name;
    private LocatorsType locatorsType;
    private String modifiedLocator;
    private String rawLocator;
    private By byLocator;


    SearchPageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
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
        if (this.modifiedLocator == null){
            this.byLocator = this.locatorsType.getBy(this.rawLocator);
        } else {
            this.byLocator = this.locatorsType.getBy(this.modifiedLocator);
        }
        return this.byLocator;
    }
}
