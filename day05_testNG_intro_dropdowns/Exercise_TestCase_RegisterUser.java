package com.cydeo.tests.day05_testNG_intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Exercise_TestCase_RegisterUser {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//a[@href='/']"));
        System.out.println("homePage.isDisplayed() = " + homePage.isDisplayed());

        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();

        WebElement newUserSignup = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        System.out.println("newUserSignup.isDisplayed() = " + newUserSignup.isDisplayed());

        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("nisa");

        WebElement eMail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        eMail.sendKeys("nnssa@mail.com");

        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        WebElement enterAccountInformation = driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        System.out.println("enterAccountInformation.isDisplayed() = " + enterAccountInformation.isDisplayed());

        WebElement fillTitle = driver.findElement(By.xpath("//input[@value='Mrs']"));
        fillTitle.click();

        WebElement fillName = driver.findElement(By.xpath("//input[@id='name']"));
        fillName.sendKeys("Nisa");

        //WebElement fillEmail = driver.findElement(By.xpath("//input[@data-qa='email']"));
        //fillEmail.sendKeys("nnssa@mail.com");
        WebElement fillPassword = driver.findElement(By.xpath("//input[@id='password']"));
        fillPassword.sendKeys("Nisa12345");
        WebElement fillDateOfBirthDay = driver.findElement(By.xpath("//select[@id='days']"));
        fillDateOfBirthDay.sendKeys("25");
        WebElement fillDateOfBirthMonth = driver.findElement(By.xpath("//select[@id='months']"));
        fillDateOfBirthMonth.sendKeys("January");
        WebElement fillDateOfBirthDayYear = driver.findElement(By.xpath("//select[@id='years']"));
        fillDateOfBirthDayYear.sendKeys("2000");

        WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();






    }




}
