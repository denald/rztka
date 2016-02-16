package rozetka.tests.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasePage {

    protected WebDriver driver;

//    public Header header = new Header (driver);

    public BasePage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeFocusFromEverything(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.click()");
    }

    public Header header(){
        return new Header(driver);
    }

    public void takeScreenshot() {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try {
            FileUtils.copyFile(srcFile, new File(".\\screenshot\\scr"+timeStamp+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot was saved");
    }

    public Boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

}

