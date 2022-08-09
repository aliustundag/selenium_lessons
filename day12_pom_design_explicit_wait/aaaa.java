package com.cydeo.tests.day12_pom_design_explicit_wait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aaaa {

    package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.Enums.USERINFO;
import QA.Jenkins.SmokeTest;
import QA.utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    public class TC_03_04 extends BrowserTestBase {


        @BeforeEach

        public void goToHomePage() {
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            //3. Verify that home page is visible successfully

            //ReusableMethods.visitURL(LINKS.REGISTER);
            ReusableMethods.visitURL(LINKS.HOME);
            Assertions.assertEquals(LINKS.HOME.getLinks(), Driver.getDriver().getCurrentUrl(), "actual Link is" + Driver.getDriver().getCurrentUrl());

        }

        @SmokeTest
        public void tc_03() {
            //4. Click on 'Signup / Login' button;
            elements.getloginLogout_Page().SignupLoginButton.click();

            //5. Verify 'Login to your account' is visible
            Assertions.assertTrue(elements.getloginLogout_Page().loginToYourAccount.isDisplayed(),"Login to your account");

            //6. Enter incorrect email address and password

            elements.getloginLogout_Page().passwordBox.sendKeys("incorrectPassword");
            elements.getloginLogout_Page().eMailLoginBox.sendKeys("incorrectEmail");

            //7. Click 'login' button
            elements.getloginLogout_Page().loginButton.click();

            //8. Verify error 'Your email or password is incorrect!' is visible
            Assertions.assertTrue(elements.getloginLogout_Page().errorMessage.isDisplayed(),"Your email or password is incorrect!");



        }

        @Test
        public void tc_04() {



            //4. Click on 'Signup / Login' button
            elements.getloginLogout_Page().SignupLoginButton.click();

            //5. Verify 'Login to your account' is visible
            Assertions.assertTrue(elements.getloginLogout_Page().loginToYourAccount.isDisplayed(),"Login to your account");
            //6. Enter correct email address and password
            elements.getloginLogout_Page().eMailLoginBox.sendKeys(USERINFO.ALICI_6.getEmail());
            elements.getloginLogout_Page().passwordBox.sendKeys(USERINFO.ALICI_6.getPassword());
            //7. Click 'login' button
            elements.getloginLogout_Page().loginButton.click();
            //8. Verify that 'Logged in as username' is visible
            Assertions.assertTrue(elements.getloginLogout_Page().LoggedInAs.isDisplayed());
            //9. Click 'Logout' button
            elements.getloginLogout_Page().logoutButton.click();
            //10. Verify that user is navigated to login page
            Assertions.assertTrue(elements.getloginLogout_Page().verifiedLoginPage.isDisplayed());



        }
    }

}



package QA.Pages;

        import QA.BrowserTestBase;
        import QA.utilities.driver.DriverFactoryImplementation;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class LoginLogout_Page extends BrowserTestBase {

    public LoginLogout_Page() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(),this);
    }

    @FindBy(xpath = "//title[.='Automation Exercise']")
    public WebElement actualTitle;

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]" )
    public WebElement SignupLoginButton;

    @FindBy(xpath = "//h2[.='Login to your account']")
    public WebElement loginToYourAccount;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement eMailLoginBox;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[.='Your email or password is incorrect!']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    public WebElement LoggedInAs;

    @FindBy(xpath = "//a[.=' Logout']" )
    public WebElement logoutButton;

    @FindBy(xpath = "//title[.='Automation Exercise - Signup / Login']")
    public WebElement verifiedLoginPage;

}




    ALICI_6("abcd","","","abcd@mail.com","12345",""),

