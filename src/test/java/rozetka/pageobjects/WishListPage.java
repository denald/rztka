package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rozetka.locators.WishlistPageLocators;
import java.util.List;
import java.util.stream.Collectors;

public class WishListPage extends Header {

    private List<WebElement> itemsInWishlist = getAll(WishlistPageLocators.ITEMS_IN_WISHLIST.getBy());

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfItemsInWishlist(){
        return itemsInWishlist;
    }

    public List<String> getNamesOfItemsInWishlist(){
        List<String> names = null;
        names.addAll(itemsInWishlist
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()));
        return names;
    }


}
