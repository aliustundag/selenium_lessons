package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task02_UploadPractice {

    @Test
    public void upload_test(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //1- Find some file fromyour computer, and get the path of it
        String path = "C:\\Users\\james\\Desktop\\download.jpg";

        //2- Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        fileUpload.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //3-Assert:
        //File uploaded text is displayed on the page

        WebElement fileUploadHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadHeader.isDisplayed());




    }



}
