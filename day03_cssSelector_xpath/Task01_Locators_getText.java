package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01_Locators_getText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        //1- enter incorrect username : "incorrect"
        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("incorrect");
        //driver.findElement(By.className("login-inp")).sendKeys("incorrect");

        //2- enter incorrect password : "incorrect"
        //To auto generate local variable
        //Mac: option + enter
        //Windows: alt + enter
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        //3- click to log in button
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //4- verify error message text is as expected
        //expected: Incorrect login or password

        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }






    }
}
