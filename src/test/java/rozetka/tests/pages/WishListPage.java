package rozetka.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by dlapin on 2/15/2016.
 */
public class WishListPage extends BasePage {

    @FindBy (className = "g-i-tile-i-title")
    private List<WebElement> itemsInWishlist;



    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfItemsInWishlist(){
        return itemsInWishlist;
    }


}
