package rozetka.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * Created by dlapin on 3/7/2016.
 */
public class TestListener extends TestListenerAdapter{
    @Override
    public void onTestFailure(ITestResult tr){
        Reporter.log(tr.getName() + " -- test method failed\n");
    }

    @Override
    public void onTestSuccess(ITestResult tr){
        Reporter.log(tr.getName() + " -- test method success\n");
    }
}
