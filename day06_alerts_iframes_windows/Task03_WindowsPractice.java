package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task03_WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void multiple_window_test() {
        //Storing the main page's window handle as string is
        //good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //1- Assert: Title is "Windows"
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        System.out.println("Title before click: "+ actualTitle);

        //2-Click to "Click Here" link

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        actualTitle = driver.getTitle();
        System.out.println("Title after click: "+ actualTitle);

        //clicked but title didn't change.


        //3- Switch to new Window
        for (String each: driver.getWindowHandles()) {
           driver.switchTo().window(each);
           System.out.println("Current title while switching windows: "+ driver.getTitle());

           //switched it and changed title

        }
        //4- Assert: Title is "New Window"
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
