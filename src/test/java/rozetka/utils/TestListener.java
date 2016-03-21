package rozetka.utils;

import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener extends TestListenerAdapter{
    @Override
    public void onTestFailure(ITestResult tr){
        final Object currentClass = tr.getInstance();
        final WebDriver driver = ((TestRunner) currentClass).getDriver();
        Reporter.log(tr.getName() + " -- test method failed\n");
        Utils.takeScreenshot(driver);
        System.out.println("FAILED");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.print("Started running test: " + result.getName() + " ... ");
    }

    @Override
    public void onTestSuccess(ITestResult tr){
        Reporter.log(tr.getName() + " -- test method success\n");
        System.out.println("SUCCESS");
    }
}
