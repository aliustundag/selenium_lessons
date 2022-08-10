package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {
    @Test
    public void task_4and_5_test() throws InterruptedException {
        Driver.getDriver().get("https://practice.cydeo.com/");

        //1- Scroll down to "Powered by CYDEO"
        //Create object of Actions and pass our "driver" instance

        Actions actions = new Actions(Driver.getDriver());
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        //2- Scroll using Actions class "moveTo(element)" method
        actions.moveToElement(cydeoLink).perform();

        //3- Scroll back up to "Home" link using PageUP button
        Thread.sleep(2000);

        // WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        // actions.moveToElement(homeLink).perform();

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();





    }
}
