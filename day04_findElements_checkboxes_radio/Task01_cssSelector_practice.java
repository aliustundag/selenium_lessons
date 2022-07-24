package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01_cssSelector_practice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");

        // A-
        //Locate all the WebElements on the page using XPATH and/or CSS
        //Locator only (total of 6)
        //1- "Home" link  (Locate homeLink using cssSelector)

        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));  //syntax #1
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));           //syntax #2

        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //2- "Forgot password" header
        // Locate header using cssSelector: locate parent element and move down to h2

        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example>h2"));

        //Locate header using xpath:

        WebElement header_ex2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']")); //syntax #1
        WebElement header_ex3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));      //syntax #2

        //3- "E=-mail" text

        WebElement eMail_ex1 = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement eMail_ex2 = driver.findElement(By.xpath("//label[@for='email']"));

        //4- E-mail input box

        WebElement eMailInputBox_ex1 = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement eMailInputBox_ex2 = driver.findElement(By.cssSelector("input[name='email']"));

        WebElement eMailInputBox_ex3 = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement eMailInputBox_ex4 = driver.findElement(By.xpath("//input[@name='email']"));

        //Syntax //tagName[contains(@attribute,'value')]
        WebElement eMailInputBox_ex5 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z0-9')]"));

        //5- "Retrieve password" button

        WebElement retrievePassword_ex1 = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePassword_ex2 = driver.findElement(By.xpath("//button[@class='radius']"));

        WebElement retrievePassword_ex3 = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")); //attribute i, don't preferred so don't use it

        //6- "Powered by Cydeo" text

        WebElement text_ex1 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement text_ex2 = driver.findElement(By.xpath("//a[@target='_blank']")); // not all of the text, just for Cydeo link
        WebElement text_ex3 = driver.findElement(By.xpath("//a[.='CYDEO']")); // not all of the text, just for Cydeo link

        // B- Verify all web elemnts are displayed.

        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("homeLink_ex2.isDisplayed() = " + homeLink_ex2.isDisplayed());
        System.out.println("homeLink_ex3.isDisplayed() = " + homeLink_ex3.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("header_ex2.isDisplayed() = " + header_ex2.isDisplayed());
        System.out.println("header_ex3.isDisplayed() = " + header_ex3.isDisplayed());
        System.out.println("eMail_ex1.isDisplayed() = " + eMail_ex1.isDisplayed());
        System.out.println("eMail_ex2.isDisplayed() = " + eMail_ex2.isDisplayed());
        System.out.println("eMailInputBox_ex1.isDisplayed() = " + eMailInputBox_ex1.isDisplayed());
        System.out.println("eMailInputBox_ex2.isDisplayed() = " + eMailInputBox_ex2.isDisplayed());
        System.out.println("eMailInputBox_ex3.isDisplayed() = " + eMailInputBox_ex3.isDisplayed());
        System.out.println("eMailInputBox_ex4.isDisplayed() = " + eMailInputBox_ex4.isDisplayed());
        System.out.println("eMailInputBox_ex5.isDisplayed() = " + eMailInputBox_ex5.isDisplayed());
        System.out.println("retrievePassword_ex1.isDisplayed() = " + retrievePassword_ex1.isDisplayed());
        System.out.println("retrievePassword_ex2.isDisplayed() = " + retrievePassword_ex2.isDisplayed());
        System.out.println("retrievePassword_ex3.isDisplayed() = " + retrievePassword_ex3.isDisplayed());
        System.out.println("text_ex1.isDisplayed() = " + text_ex1.isDisplayed());
        System.out.println("text_ex2.isDisplayed() = " + text_ex2.isDisplayed());
        System.out.println("text_ex3.isDisplayed() = " + text_ex3.isDisplayed());


    }
}
