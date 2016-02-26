package rozetka.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlapin on 2/12/2016.
 */
public class SearchPage extends BasePage{

    @FindBy(className = "search-result-title-text")
    private WebElement searchResultTitleText;

    @FindBy (className = "btn-link-i")
    private WebElement submitToWishListPopupButton;

    @FindBy (className = "popup-close")
    private WebElement closeWishPopupIcon;

    @FindBy (className = "g-i-list-title")
    private List<WebElement> titlesOnSearchPage;

    @FindBy (className = "g-rating-reviews")
    private List<WebElement> reviewsCountList;




    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitleText(){
        return searchResultTitleText.getText();
    }

    public String getColorOfSearchTitle(){
        return searchResultTitleText.getCssValue("color");
    }

    public void addToWishList(int position){
        driver.findElements(By.name("towishlist")).get(position-1).click();
        submitToWishlist();
    }

    public void submitToWishlist(){
        submitToWishListPopupButton.click();
        closeWishPopupIcon.click();
    }

    public String getProductNameByPosition(int position){
        return titlesOnSearchPage.get(position -1).getText();
    }

    public List<String> getListOfTitles(){
        List<String> titles = new ArrayList<>();
        for (WebElement title: titlesOnSearchPage) {
            titles.add(title.getText());
        }
        return titles;
    }

    public int getCountOfReviewsByPosition(int position){
        return Integer.parseInt(reviewsCountList.get(position-1).getText().replaceAll("[^\\d.]+", ""));

    }

    public ProductDetailsPage goToProductByPosition(int productPosition) {
        titlesOnSearchPage.get(productPosition-1).click();
        return new ProductDetailsPage(driver);
    }
}
