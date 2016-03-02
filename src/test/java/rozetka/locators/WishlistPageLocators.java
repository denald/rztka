package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;


public enum  WishlistPageLocators implements ILocator {

    ITEMS_IN_WISHLIST(
            "Items in wishlist",
            LocatorsType.BY_CLASS_NAME,
            "g-i-tile-i-title"
    );

    private String name;
    private LocatorsType locatorsType;
    private String modifiedLocator;
    private String rawLocator;
    private By byLocator;


    WishlistPageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
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

