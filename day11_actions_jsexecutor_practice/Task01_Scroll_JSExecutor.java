package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task01_Scroll_JSExecutor {

    @Test
    public void scroll_text(){

        Driver.getDriver().get("https://practice.cydeo.com/large");

        //JavaScript method to use : arguments[0].scrollIntoView(true)
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //1- Scroll down to "Cydeo" link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        //2- Scroll down to "Home" link
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);
        //js.executeScript("arguments[0].scrollIntoView(true)",homeLink);




    }


}
