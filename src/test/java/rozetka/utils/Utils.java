package rozetka.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Utils {

    public void takeScreenshot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try {
            FileUtils.copyFile(srcFile, new File(".\\screenshot\\scr" + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot was saved");
    }


//    public Boolean isElementPresent(WebDriver driver, WebElement element) {
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        try {
//            element.isDisplayed();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            return true;
//        } catch (NoSuchElementException e) {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            return false;
//        }
//    }

    public static void removeFocusFromEverything(final WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.click()");
    }

}