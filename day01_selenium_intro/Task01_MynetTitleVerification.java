package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01_MynetTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mynet.com");

        String expectedTitle = "Mynet | Haber, Oyun, Video, Spor, Burçlar ve fazlası sizin için burada";
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title is as expected. Verification Passed");

        }else{
            System.out.println("Title is Not as expected. Verification Failed!");
        }



    }
}
