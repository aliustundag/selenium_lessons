package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task02_CRM_LOGIN extends TestBase {



    @Test

    public void crm_login_test() {
        driver.get("https://login1.nextbasecrm.com/");

        //1- Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");


        //2- Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //3- Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //4- Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver, "Portal");


    }

    @Test

    public void crm_login_test_2() {
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);  //(1-,2-,3-)

        //4- Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @Test

    public void crm_login_test_3() {
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver,"helpdesk2@cybertekschool.com","UserUser");  //(1-,2-,3-)

        //4- Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver, "Portal");

    }
}
