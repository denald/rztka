package rozetka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by dlapin on 2/10/2016.
 */
public class HomePage extends BasePage {

    @FindBy (xpath = "//span[@class='new m-main-l-i-new']")
    private List<WebElement> newBadges;

    @FindBy (xpath = "/html")
    private WebElement bodyOfThePage;

    @FindBy (partialLinkText = "Смартфоны")
    private WebElement smartphonesLink;

    @FindBy (xpath = "//a[@href='http://rozetka.com.ua/smartphones/c80010/']")
    private WebElement subMenuPhones;


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNewBadges(){
        return newBadges;
    }

    public ProductsPage goToSmartfonesMenu(){
        smartphonesLink.click();
        return new ProductsPage(driver);
    }

}
