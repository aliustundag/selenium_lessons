package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task04_StaleElementReferenceException {

    public static void main(String[] args) {

        //* What are the causes of StaleElement Exception
        //Cause 1 : The referenced web element has been deleted completely
        //Cause 2 : The referenced element no longer attached to the DO
        // Usually throws when navigation(refresh,forward,back)happens

        //* How to handle?
        // if element due to deleted from the page; using try/catch to avoid exception being thrown and set our own condition
        // if it due to navigate; we can re-assign/connection of the web element.


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/abtest");

        //1- Locate "CYDEO" link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();

        //5- Verify it is displayed, again.

        // if we want to solve this exception ,we re-assign  again in this line as below line
        //WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());



    }
}
