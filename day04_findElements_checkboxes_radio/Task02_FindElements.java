package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task02_FindElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //Providing extra wait time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/abtest");

        //1- Locate all the links in the page
        //windows : alt+enter --> press enter again
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));


        //2- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());

        //3- Print out the texts of the links.
        //3- Print out the HREF attribute values of the links
        for (WebElement each : allLinks) {
            System.out.println("Text of link = " + each);
            System.out.println("Text of linkName = " + each.getText());
            System.out.println("HREF Values = " + each.getAttribute("href"));
        }


    }
}



