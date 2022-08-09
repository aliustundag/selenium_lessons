package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriveWaitPractices {

    @Test
    public void dynamic_load_test(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        //Wait until title is "Dynamic title"
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //Assert: message "DONE" is displayed
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //Assert: image is displayed
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());



    }

    @Test
    public void dynamic_load_1_test(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page =new DynamicLoad1Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //Click to start
        dynamicLoad1Page.startButton.click();

        //wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        //Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");

        //Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");

        //click to submit method
        dynamicLoad1Page.submitButton.click();

        //Assert " Your password is invalid" text is displayed.

        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());


    }


}
