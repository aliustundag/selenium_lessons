package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class Task01_WindowHandling{
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void window_handling_test(){

        driver.get("https://www.amazon.com");


        (( JavascriptExecutor)driver).executeScript("window.open('https://google.com','_blank');");
        (( JavascriptExecutor)driver).executeScript("window.open('https://etsy.com','_blank');");
        (( JavascriptExecutor)driver).executeScript("window.open('https://facebook.com','_blank');");


        for (String each: driver.getWindowHandles()) {
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            //all Url = www.amazon.com but different site so need switch them

        }

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("After switch --> driver.getCurrentUrl() = " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }

        }
        //Assert: Title contains "Etsy"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }




}
