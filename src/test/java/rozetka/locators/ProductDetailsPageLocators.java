package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;


public enum  ProductDetailsPageLocators implements ILocator {

    PRODUCT_PAGE_TITLE(
            "Product page title",
            LocatorsType.BY_CLASS_NAME,
            "detail-title"
    ),
    PRODUCT_PRICE(
            "Product price",
            LocatorsType.BY_XPATH,
            "//div[@class='detail-price-uah']"
    ),
    REVIEW_RATE(
            "Review rate",
            LocatorsType.BY_XPATH,
            "//span[@class='sprite g-rating-stars-i-medium']"
    ),
    REVIEWS_COUNT(
            "Reviews count",
            LocatorsType.BY_XPATH,
            "//span[@itemprop='aggregateRating']"
    ),
    REVIEW_DETAILS_TAB_TITLE(
            "Review details tab title",
            LocatorsType.BY_CLASS_NAME,
            "pp-review-heading-title"
    );

    private String name;
    private LocatorsType locatorsType;
    private String rawLocator;
    private By byLocator;

    ProductDetailsPageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
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
        return byLocator;
    }
}
