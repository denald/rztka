package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rozetka.elements.Link;
import rozetka.locators.HeaderLocators;
import rozetka.locators.HomePageLocators;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Header {

    final private List<WebElement> newBadges = getAll(HomePageLocators.NEW_BADGES_ICON.getBy());
    final private Link smartphonesLink = new Link(driver, HomePageLocators.SMARTPHONES_PAGE_LINK.getBy());
    final private Link subMenuPhones = new Link(driver, HomePageLocators.SUBMENU_PHONES.getBy());


    public HomePage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getNewBadges(){
        return newBadges;
    }

    public ProductsPage goToSmartfonesMenu(){
        smartphonesLink.click();
        return new ProductsPage(driver);
    }

}
