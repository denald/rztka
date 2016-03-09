package rozetka.utils;

import org.testng.*;

/**
 * Created by dlapin on 3/7/2016.
 */
public class TestListener extends TestListenerAdapter{
    @Override
    public void onTestFailure(ITestResult tr){
        Reporter.log(tr.getName() + " -- test method failed\n");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Started running test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr){
        Reporter.log(tr.getName() + " -- test method success\n");
    }
}
