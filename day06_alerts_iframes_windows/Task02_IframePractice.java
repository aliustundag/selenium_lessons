package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task02_IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void iframe_test() {
        //We need to switch driver's focus to iframe

        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");
        //OR
        //option #2
        //driver.switchTo().frame(0);
        //OR option #3
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));





        //1-Locate the p tag
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //2-Verify "An iFrame containing the TinyMCE WYSIWYG Editor"
        //To be able to verify the header, we must switch back to "main HTML"
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());
    }
}
