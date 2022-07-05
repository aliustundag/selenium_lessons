package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_Practice {
    public static void main(String[] args) {

        //1- Open Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to "http://practice.cybertekschool.com"
        driver.get("http://practice.cybertekschool.com");

        //3- Click to A/B Testing from top of the list
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();
        // or
        //driver.findElement(By.linkText("A/B Testing")).click();

        //4- Verify title list
        // Expected : No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Verification Pass");
        }else{
            System.out.println("Title Verification Failed");
        }

        //5- Go back to home page by using the .back();
        driver.navigate().back();

        //6- Verify title equals
        // Expected : Practice

        String expectedTitle2 = "Practice";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle2)){
            System.out.println("Title Verification Pass");
        }else{
            System.out.println("Title Verification Failed");
        }



    }
}
