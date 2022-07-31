package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task01_Alert_Practices {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public  void alert_test1(){
        //Click to "Click for JS Alert" button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //Click to OK button from th alert
        alert.accept();

        //Verify "You successfully clicked an alert" text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        //Failure meesage will only be displayed if assertion fails: "Result text is NOT displayed"
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed");

        String expectedText ="You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected");


    }
}
