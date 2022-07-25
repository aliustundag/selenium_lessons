package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task03_CheckBoxes {

    public static void main(String[] args) throws InterruptedException {

        WebDriver diver = WebDriverFactory.getDriver("Chrome");
        diver.manage().window().maximize();
        diver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        diver.get("https://practice.cydeo.com/checkboxes");

        //We have to locate checkboxes
        WebElement checkbox1 = diver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = diver.findElement(By.xpath("//input[@name='checkbox2']"));

        //1- confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isSelected(), expecting false  = " + checkbox1.isSelected());

        //2- confirm checkbox #2 is Selcted by default
        System.out.println("checkbox2.isSelected(), expecting true = " + checkbox2.isSelected());

        //3- Click checkbox #1 to select it
        Thread.sleep(2000);
        checkbox1.click();

        //4- Click checkbox #2 to deselect it
        Thread.sleep(2000);
        checkbox2.click();

        //5- Confirm checkbox #1 is SELECTED
        System.out.println("checkbox2.isSelected(), expecting FALSE = " + checkbox2.isSelected());

        //6- Confirm checkbox #1 is  NOT SELECTED
        System.out.println("checkbox1.isSelected(), expecting TRUE = " + checkbox1.isSelected());


    }



}
