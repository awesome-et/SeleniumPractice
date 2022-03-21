package Locators;

import static Interface.ClassObjects.*;

import Setup.Setup;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.awt.*;

public class TopicSelection extends Setup {

//    @Test
//    public void performBasicAuth() throws InterruptedException {
//        dashboardScreen.clickBasicAuth();
////        Thread.sleep(3000);
////        Alert alert = driver.switchTo().alert();
////        alert.sendKeys("admin");
////        alert.sendKeys("admin");
//    }

//    @Test
//    public void addRemoveElements() throws InterruptedException {
//        dashboardScreen.addRemoveElements();
//    }

//    @Test
//    public void handleCheckBoxes() throws InterruptedException {
//        dashboardScreen.handleCheckBoxes();
//    }

//    @Test
//    public void handleContextClick() throws InterruptedException {
//        dashboardScreen.handleContextClick();
//    }

//    @Test
//    public void dragAndDrop() throws InterruptedException {
//        dashboardScreen.dragAndDrop();
//    }

//    @Test
//    public void dropDown() throws InterruptedException {
//        dashboardScreen.dropDown();
//    }

//    @Test
//    public void entryAd() throws InterruptedException {
//        dashboardScreen.entryAd();
//    }

    @Test
    public void horizontalSlider() throws InterruptedException, AWTException {
        //Pass value between 0 to 5 in multiples of 0.5
        dashboardScreen.horizontalSliderLinkClick();
        dashboardScreen.horizontalSlider(1);
        dashboardScreen.horizontalSlider(3.5);
    }

    @AfterSuite
    public void closure() {
//        driver.close();
//        driver.quit();

    }
}