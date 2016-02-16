package rozetka.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dlapin on 2/15/2016.
 */
public class ProductDetailsPage extends BasePage {

    @FindBy (className = "detail-title")
    private WebElement productPageTitle;

    @FindBy (xpath = "//div[@class='detail-price-uah']")
    private WebElement productPrice;

    @FindBy (xpath = "//span[@class='sprite g-rating-stars-i-medium']")
    private WebElement reviewRate;

    @FindBy (xpath = "//span[@itemprop='aggregateRating']")
    private WebElement reviewsCount;

    @FindBy (className = "pp-review-heading-title")
    private WebElement reviewDetailsTabTitle;

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


    public WebElement getReviewDetailsTabTitle() {
        return reviewDetailsTabTitle;
    }
}
