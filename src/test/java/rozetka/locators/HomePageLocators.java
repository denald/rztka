package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;

public enum  HomePageLocators implements ILocator {

    NEW_BADGES_ICON(
            "New badges icon",
            LocatorsType.BY_XPATH,
            "//span[@class='new m-main-l-i-new']"
    ),
    SMARTPHONES_PAGE_LINK(
            "Smartphones page link",
            LocatorsType.BY_PARTIAL_LINK_TEXT,
            "Смартфоны"
    ),
    SUBMENU_PHONES(
            "Phones sub menu",
            LocatorsType.BY_XPATH,
            "//a[@href='http://rozetka.com.ua/smartphones/c80010/']"
    );


    private String name;
    private LocatorsType locatorsType;
    private String rawLocator;
    private By byLocator;

    HomePageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
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
