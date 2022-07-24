package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task04_cssSelector_getText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //Verify "Reset Password" button text is as expected:
        //Expected: Reset Password

        //WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password'"));

        String expectedResetPasswordButtonText = "Reset password";
        String actualResetPasswordButtonText = resetPasswordButton.getText();

        //if it is in between openin tag and closing tag, we use getAttribute
        // if it is not, getText

        if (actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");

            //
        }





    }
}
