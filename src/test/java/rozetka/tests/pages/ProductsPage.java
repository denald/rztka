package rozetka.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dlapin on 2/15/2016.
 */
public class ProductsPage extends BasePage {

    String _productManufacturerLocator = "//span[contains(.,'%s')]";
    String _productNameByPositionLocator = "(//div[@class='g-i-tile-i-title clearfix'])[%s]";
    String _productPriceByPositionLocator = "(//div[@class='g-price-uah'])[%s]";
    String _productRatingByPositionLocator = "(//span[@class='sprite g-rating-stars-i'])[%s]";



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductManufacturer(String manufacturer){
        String productManufacturerLocator = String.format(_productManufacturerLocator, manufacturer);
        driver.findElement(By.xpath(productManufacturerLocator)).click();
    }

    public String getProductNameByPosition(int position){
        String productNameByPositionLocator = String.format(_productNameByPositionLocator, position);
        return driver.findElement(By.xpath(productNameByPositionLocator)).getText();
    }

    public String getProductPriceByPosition(int position){
        String productPriceByPositionLocator = String.format(_productPriceByPositionLocator, position);
        return driver.findElement(By.xpath(productPriceByPositionLocator)).getText().replaceAll("[^\\d.]+", "");
    }

    public String getProductReviewRateByPosition(int position){
        String productRatingByPositionLocator = String.format(_productRatingByPositionLocator, position);
        return driver.findElement(By.xpath(productRatingByPositionLocator)).getAttribute("style");
    }

    public ProductDetailsPage selectProductByPosition(int position){
        String productNameByPositionLocator = String.format(_productNameByPositionLocator, position);
        driver.findElement(By.xpath(productNameByPositionLocator)).click();
        return new ProductDetailsPage(driver);
    }


}
