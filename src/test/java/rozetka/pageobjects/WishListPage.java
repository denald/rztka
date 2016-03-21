package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rozetka.locators.WishlistPageLocators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import rozetka.utils.Utils;

public class WishListPage extends BasePage {

    private List<WebElement> itemsInWishlist = getAll(WishlistPageLocators.ITEMS_IN_WISHLIST.getBy());

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfItemsInWishlist(){
        return itemsInWishlist;
    }

    public List<String> getNamesOfItemsInWishlist(){
        List<String> names = new ArrayList<>();
        names.addAll(itemsInWishlist
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()));
        return names;
    }


}
