package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rozetka.locators.WishlistPageLocators;
import java.util.List;

public class WishListPage extends BasePage {

    private List<WebElement> itemsInWishlist = getAll(WishlistPageLocators.ITEMS_IN_WISHLIST.getBy());

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfItemsInWishlist(){
        return itemsInWishlist;
    }


}
