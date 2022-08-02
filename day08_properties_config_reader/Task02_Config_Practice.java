package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task02_Config_Practice {

//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod() {
//
//        //We are getting the browserType dynamically from our configuration.properties file
//        String browserType = ConfigurationReader.getProperty("browser");
//        driver = WebDriverFactory.getDriver(browserType);
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }

    @Test
    public void google_search_test(){

        Driver.getDriver().get("https://www.google.com");
        WebElement cookiesButton = Driver.getDriver().findElement(By.id("L2AGLb"));
        cookiesButton.click();

        // Write "apple" in searh box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        // googleSearchBox.sendKeys("apple"+ Keys.ENTER);
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //Verify title
        BrowserUtils.verifyTitle(Driver.getDriver(),ConfigurationReader.getProperty("searchValue")+" - Google Search");






    }


}
