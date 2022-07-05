package com.cydeo.tests.day01_selenium_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        // 1- Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Selenium WebDriver
        // This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the browser size
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); is the same as above but sometimes it doesn't work Windows

        //3- Go to " https://www.tesla.com "
        driver.get("https://www.tesla.com");

        //get the tittle of the page
        String currentTittle = driver.getTitle();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //use navigate().to();
        driver.navigate().to("https://www.google.com");

        //get the tittle of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("currentTittle = " + currentTittle);

        //get the current URL using Selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // this will close only the currently openeded browser
        //if we have more than one window open, it will only close the one that was focused on
        driver.close();

        // this will close all of the opened the windows
        // it kills the current session.
        //it means if more than one window was opened, everything will be closed.
        // after using .quit() method, we cannot execute any more line of codes.
        // we will get "NoSuchSessionException
        driver.quit();




    }
}
