package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utulities.WebDriverFactory;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02_getText_getAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        //1- Verify "remember me" label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
         //2- Verify "forgot password" link text is as expected:
        //Expected : FORGOT YOUR PASSWORD?

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedPasswordLink = "FORGOT YOUR PASSWORD?";
        String actualPasswordLink = forgotPasswordLink.getText();

        if (actualPasswordLink.equals(expectedPasswordLink)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        //3- Verify "forgot password" href attribute's value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualHrefAttributeValue = forgotPasswordLink.getAttribute("href");

        System.out.println("actualHrefAttributeValue = " + actualHrefAttributeValue);

        if (actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("Href attribute value verification Passed");
        }else{
            System.out.println("Href attribute value verification Failed");
        }




    }
}
