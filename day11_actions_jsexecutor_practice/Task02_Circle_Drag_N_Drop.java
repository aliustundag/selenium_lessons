package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task02_Circle_Drag_N_Drop {

     @Test
    public void drag_and_drop_test(){
         Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
         WebElement cookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
         cookiesButton.click();

         //1- Drag and Drop the small circle to bigger circle
         WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
         WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

         Actions actions = new Actions(Driver.getDriver());
         actions.dragAndDrop(smallCircle,bigCircle).perform();

         //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

         //2- Assert

          String actualBigCircleText = bigCircle.getText();
          String expectedBigCircleText = "You did great!";
          Assert.assertEquals(actualBigCircleText,expectedBigCircleText);

         //-Text in big circle changed to: "You did great!"




     }




}
