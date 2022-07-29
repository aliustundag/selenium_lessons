package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");


    }
    @Test
    public void dropdown_task5() throws InterruptedException {
        // Select illinols,Virginia,California

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(2000);
        stateDropdown.selectByValue("VA");
        Thread.sleep(2000);
        stateDropdown.selectByIndex(5);

        // Verify final selected option is California
        String expectedOptionText ="California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);

    }

    @Test
    public  void dropdown_task6() throws InterruptedException {
        //Select "December 1 , 1923" and verify it is selected. Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");
        Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        Thread.sleep(1000);
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actaulyear = year.getFirstSelectedOption().getText();
        String actaulmonth = month.getFirstSelectedOption().getText();
        String actaulday = day.getFirstSelectedOption().getText();

        Assert.assertEquals(actaulyear, expectedYear);
        Assert.assertEquals(actaulmonth, expectedMonth);
        Assert.assertTrue(actaulday.equals(expectedDay));
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();

    }


}
