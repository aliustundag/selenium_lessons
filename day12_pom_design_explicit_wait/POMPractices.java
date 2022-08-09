package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utulities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage = new LibraryLoginPage();
    }


    @Test
    public void required_field_error_message_test(){
        //Do not enter any information
        //Click to "Sign in" button
        libraryLoginPage.signInButton.click();

        //Verify expected error is displayed:
        //Expected: This field is required

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();


    }

    @Test
    public void invalid_email_format_error_message_test(){

        //Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("somethingwrong");
        libraryLoginPage.signInButton.click();

        //verify
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();



    }

    @Test
    public void library_negative_test(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.inputUsername.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");
        libraryLoginPage.signInButton.click();
        //Verify
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

        Driver.closeDriver();


    }



}
