package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utulities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test

    public void selenium_test(){

        driver.get("https://google.com");

        String actaulTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actaulTitle,expectedTitle,"Title is not matching here."); // if the test fails, give us a "message"






    }


}
