package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task03_Actions_Hover {

    @Test
    public void hovering_test(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        //Locate all images under here
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the "user" text
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));


        Actions actions = new Actions(Driver.getDriver());

        //1-Hover over to first image
        BrowserUtils.sleep(2);
        actions.moveToElement(img1).perform();
        //2- Assert:
        //a. "name: user1" is displayed
        Assert.assertTrue(user1.isDisplayed());


        //3-Hover over to second image
        BrowserUtils.sleep(2);
        actions.moveToElement(img2).perform();
        //4- Assert:
        //a. "name: user2" is displayed
        Assert.assertTrue(user2.isDisplayed());


        //5-Hover over to third image
        BrowserUtils.sleep(2);
        actions.moveToElement(img3).perform();
        //6- Assert:
        //a. "name: user3" is displayed
        Assert.assertTrue(user3.isDisplayed());


    }
}
