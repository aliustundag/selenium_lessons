package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task05_StaleElementRefEx {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //1- Click to "Add Element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(2000);
        addElementButton.click();

        //2- Verify "Delete" button is displayed after clicking.

        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //3-Click "delete" button
        deleteButton.click();

        //4-Verify "delete" button is Not displayed after clicking

        try {

            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        } catch (StaleElementReferenceException e) {
            System.out.println("--> StaleElementReferenceException exception is thrown");
            System.out.println("--> This meas the web element is completely deleted from the page");
            System.out.println("delete Button.isDisplayed() = false");
        }
        driver.close();

    }
}
