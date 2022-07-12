package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task05_getText_getAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/registration_form");

        // Verify header text is as expected:
        // Expected: Registration form

        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expetedHeaderText = "Registration form";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expetedHeaderText)){
            System.out.println("Header Text Verification PASSED");
        }else{
            System.out.println("Header Text Verification FAILED");
        }

        //Locate "First name" input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        //Verify placeholder attribute's value is as expected:
        // Expected: fisrt name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");
        if (actualHeaderText.equals(expetedHeaderText)){
            System.out.println("Placeholder Text Verification PASSED");
        }else{
            System.out.println("Placeholder Text Verification FAILED");
        }

        driver.close();



    }
}
