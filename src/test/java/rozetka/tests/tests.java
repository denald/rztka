package rozetka.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import rozetka.tests.pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dlapin on 2/10/2016.
 */
public class tests {

    private WebDriver driver;
    private String BASE_URL = "http://rozetka.com.ua";
    private HomePage homePage;
    private final String USER_LOGIN = "denysltest12312313@gmail.com";
    private final String USER_PASSWORD = "qaZser56$";
    private final String USER_NAME = "Deee";

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setupMethod(){
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDownMethod(){
        homePage.header().logOut();
    }

    @Test
    public void testLogin(){
        homePage.header().logInAs(USER_LOGIN, USER_PASSWORD);
        Assert.assertTrue(homePage.header().getLoginLinkText().equals(USER_NAME));
    }

    @Test
    //TODO: finish this test
    public void testNewCategoriesArePresent(){
        String expectedColor = "rgba(251, 63, 76, 1)";
        Reporter.log("There are " + homePage.getNewBadges().size() + " NEW badges in main menu");
        for(WebElement category : homePage.getNewBadges()){
            Assert.assertEquals(category.getCssValue("background-color"), expectedColor, "Color doesn't matches");
        }
    }

    @Test
    public void testFindButtonBehavior(){
        homePage.header().clickOnSearchBar();
        Assert.assertTrue(homePage.header().searchButtonIsDisplayed(),
                "Button is not visible");
        homePage.removeFocusFromEverything();
        Assert.assertFalse(homePage.header().searchButtonIsDisplayed(),
                "Button is still visible");
    }

    @Test
    public void testKeyWord(){
        String keyword = "samsung";
        String expectedColor = "rgba(51, 51, 51, 1)";
        int position = 3;

        homePage.header().logInAs(USER_LOGIN, USER_PASSWORD);
        SearchPage searchPage = homePage.header().searchFor(keyword);
        Assert.assertEquals(searchPage.getSearchResultTitleText(), keyword,
                "Search result Title and Keyword doesn't match");
        Assert.assertTrue(searchPage.getColorOfSearchTitle().equals(expectedColor),
                "Color doesn't match");
        String productName = searchPage.getProductNameByPosition(position);
        searchPage.addToWishList(position);
        WishListPage wishListPage = homePage.header().goToWishList();
        wishListPage.takeScreenshot();
        List <String> list = new ArrayList<String>();
        for (WebElement item: wishListPage.getListOfItemsInWishlist()){
            list.add(item.getText());
        }
        Assert.assertTrue(list.contains(productName),
                "Item is not present in wishlist");

    }

    @Test
    public void testCase05(){
        int phonePosition = 3;
        final String PRODUCT_MANUFACTURER = "HTC";

        ProductsPage phonesPage = homePage.goToSmartfonesMenu();
        phonesPage.selectProductManufacturer(PRODUCT_MANUFACTURER);
        String phonePrice = phonesPage.getProductPriceByPosition(phonePosition);
        String  reviewRate = phonesPage.getProductReviewRateByPosition(phonePosition);
        ProductDetailsPage phoneDetailsPage = phonesPage.selectProductByPosition(phonePosition);
        Assert.assertEquals(phoneDetailsPage.getReviewsRate(), reviewRate,
                "Reviews count is not matching");
        Assert.assertEquals(phoneDetailsPage.getProductPrice(), phonePrice,
                "Prise isn't matching");
    }


    @Test
    public void testCase06(){
        final String SEARCH_PHRASE = "IPAD 16GB";
        final String KEYWORD = SEARCH_PHRASE.substring(5);
        final int productPosition = 1;
        SearchPage searchPage;

        searchPage= homePage.header().searchFor(SEARCH_PHRASE);
        List<String> searchResultsTitles = searchPage.getListOfTitles();
        for (String title: searchResultsTitles) {
            Assert.assertTrue(title.contains(KEYWORD),
                    "Title doesn't contains " + KEYWORD);
        }
        int countOfReviews = searchPage.getCountOfReviewsByPosition(productPosition);
        ProductDetailsPage productDetailsPage = searchPage.goToProductByPosition(productPosition);
        Assert.assertEquals(productDetailsPage.getCountOfreviews(), countOfReviews,
                "Count of reviews isn't matching");
        productDetailsPage.goToReviewsTab();
        Assert.assertTrue(productDetailsPage.getReviewDetailsTabTitle().isDisplayed(),
                "Reviews Tab is not desplayed");

    }

}
