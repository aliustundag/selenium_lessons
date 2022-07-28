package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task04_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");


    }

    @Test
    public void simpleDropdownTest(){

        // Verify "Simple dropdown" default selected value is correct
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText = currentlySelectedOption.getText();
        String expectedSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdown);

        // Verify"State selection" default selected value is correct

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateSelectionText = stateSelection.getFirstSelectedOption().getText();
        String expectedStateSelectionText = "Select a State";
        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdown,"Select a State");




    }

}
