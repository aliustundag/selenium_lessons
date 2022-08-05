package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Task04_JavaScriptExecutor {
    @Test
    public void javascript_executor_test1(){
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(1);
        js.executeScript("window.scrollBy(0,750)");

       // ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,750)");


        //a. 750 pixels down 10 times

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }
        //b. 750 pixels up 10 times

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");

        }

    }
}
