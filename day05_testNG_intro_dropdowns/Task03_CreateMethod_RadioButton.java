package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task03_CreateMethod_RadioButton {

    public static void main(String[] args) {

        //create utulity method to handle before task (Task02_RadioButton_cont)
        //method name: clickAndVerifyRadioButton
        //Return type:void or boolean
        //Method args
        //   1-WebDriver
        //   2-Name attribute as String( for providing which group of radio buttons)
        //   3-Id attribute as String( for providing which radio button to be clicked)

        //Method should loop through the given group of radio buttons. When it finds the matching option,
        //it should click and verify option is selected.

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");

        clickAndVerifyRadioButton(driver, "sport","hockey");
        clickAndVerifyRadioButton(driver, "sport","football");

        clickAndVerifyRadioButton(driver, "color","yellow");


    }


    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute)); //Alt+enter
        for (WebElement each : radioButtons) {

            String eachId = each.getAttribute("id");

            if (eachId.equals("hockey")) {
                each.click();
                System.out.println("Hockey is selected : " + each.isSelected());

                break;
            }
        }
    }
}
