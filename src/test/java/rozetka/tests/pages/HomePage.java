package rozetka.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dlapin on 2/10/2016.
 */
public class HomePage extends BasePage {

    @FindBy (xpath = "//a[@is_new='new']")
    private List<WebElement> categoriesWithNew;

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
    public void getCategoriesListWithNewBadge(){
        //This method returns both Catefories and Subcategories with badge NEW
        System.out.println(categoriesWithNew.size());
    }

    public ProductsPage goToSmartfonesMenu(){
        smartphonesLink.click();
        return new ProductsPage(driver);
    }

}
