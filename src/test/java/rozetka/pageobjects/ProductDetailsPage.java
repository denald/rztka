package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rozetka.elements.Link;
import rozetka.elements.TextElement;
import rozetka.locators.ProductDetailsPageLocators;

public class ProductDetailsPage extends Header {

    final private TextElement productPageTitle = new TextElement(driver, ProductDetailsPageLocators.PRODUCT_PAGE_TITLE);
    final private TextElement productPrice = new TextElement(driver, ProductDetailsPageLocators.PRODUCT_PRICE);
    final private TextElement reviewRate = new TextElement(driver, ProductDetailsPageLocators.REVIEW_RATE);
    final private Link reviewsCount = new Link(driver, ProductDetailsPageLocators.REVIEWS_COUNT);
    final private TextElement reviewDetailsTabTitle = new TextElement(driver, ProductDetailsPageLocators.REVIEW_DETAILS_TAB_TITLE);

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getReviewsRate(){
        return reviewRate.getAttribute("style");
    }

    public String getProductPrice(){
        return productPrice.getText().replaceAll("[^\\d.]+", "");

    }
    public String getProductName(){
        return "";
    }

    public int getCountOfreviews() {
        return Integer.parseInt(reviewsCount.getText().replaceAll("[^\\d.]+", ""));
    }

    public void goToReviewsTab() {
        reviewsCount.click();
    }

//    @TODO: Fix this!!!!
//    public WebElement getReviewDetailsTabTitle() {
//        return reviewDetailsTabTitle;
//    }
}
