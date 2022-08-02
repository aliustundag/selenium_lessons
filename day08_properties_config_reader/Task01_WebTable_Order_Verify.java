package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utulities.WebDriverFactory;
import com.cydeo.utulities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task01_WebTable_Order_Verify {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_name_verify_test() {

        //1- Verify Bob's name is listed as expected
        //Expected: "Bob Martin"

        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]"));
        //Or   "//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"

        System.out.println("bobMartinCell = " + bobMartinCell.getText());

        //2- Verify Bob's name is listed as expected

        String expectedName = "Bob Martin";
        String actualName = bobMartinCell.getText();
        Assert.assertEquals(expectedName, actualName);

        //3- Verify Bob Martin's order date is as expected
        //Expected : 12/31/2021

        WebElement orderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        //Or           "//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/..td[5]"


        String expectedBobDate = "12/31/2021";
        String actualBobDate = orderDate.getText();

        Assert.assertEquals(expectedBobDate, actualBobDate);


    }

    //We use the utulity method we created
    @Test

    public void test2() {
        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);

        String customerOrderDate4 = WebTableUtils.returnOrderDate(driver, "Bart Fisher");
        System.out.println("customerOrderDate4 = " + customerOrderDate4);
    }


    // Using WebTableUtils.orderVerify(); method
    @Test

    public void test3() {
        WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");


    }
}
