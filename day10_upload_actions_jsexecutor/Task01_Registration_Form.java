package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Task01_Registration_Form {

    @Test
    public void registration_form_test(){

        //USE JAVAFAKER AND READ CONFIGURATION.PROPERTIES FILE

        //1-Open browser
        //2-Go to website: "https://practice.cydeo.com/registration_form"
        //Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //Create JavaFaker object for next steps
        Faker faker = new Faker();

        //3-Enter First name
        WebElement inputFirstName = Driver.getDriver().findElement(By.name("firstname"));

        inputFirstName.sendKeys(faker.name().firstName());

        //4-Enter Last name
        WebElement inputLastName = Driver.getDriver().findElement(By.name("lastname"));
        inputLastName.sendKeys(faker.name().lastName());

        //5-Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.name("username"));
        String user = faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);

        //6-Enter email address
        WebElement inputEmailAddress = Driver.getDriver().findElement(By.name("email"));
        inputEmailAddress.sendKeys(user+"@email.com");

        //7-Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.name("password"));
        inputPassword.sendKeys(faker.numerify("########"));

        //8-Enter phone Number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.name("phone"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9-Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        inputGender.click();

        //10-Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.name("birthday"));
        //faker.number().numberBetween(2004,1920);
        inputBirthday.sendKeys("03/08/2000");

        //11-Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name("department")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        //12-Select Job title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13- Select Programming language from checkboxes

        List<WebElement> languageCheckBoxes = Driver.getDriver().findElements(By.xpath("//div[@class='form-check form-check-inline']"));
        WebElement randomCheckbox = languageCheckBoxes.get(new Random().nextInt(1,3));
        randomCheckbox.click();













    }

}
