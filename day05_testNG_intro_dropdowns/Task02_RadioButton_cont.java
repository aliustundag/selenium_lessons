package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task02_RadioButton_cont {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate name='sports' radio buttons and store them in a List of Web Element
        List<WebElement> sportRadioButtons = driver.findElements(By.name("sport")); //Alt+enter

        //Loop through the list of WebElement and select matching result "hockey"
        for (WebElement each : sportRadioButtons) {

            String eachId = each.getAttribute("id");
            System.out.println("eachId = " + eachId);

            if (eachId.equals("hockey")) {
                each.click();
                System.out.println("Hockey is selected : " + each.isSelected());

                break;

            }

        }


    }
}
