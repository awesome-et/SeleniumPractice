package Test;

import static Interface.ClassObjects.*;

import Setup.Setup;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import java.awt.*;

@Test(groups = "AllTests")

public class Runner extends Setup {

    @Test(groups = "basicAuth")
    public void performBasicAuth() throws AWTException {
        dashboardScreen.clickBasicAuth();
    }

    @Test(groups = "addRemoveElements")
    public void addRemoveElements() {
        dashboardScreen.addRemoveElements();
    }

    @Test(groups = "checkBoxes")
    public void handleCheckBoxes() {
        dashboardScreen.handleCheckBoxes();
    }

    @Test(groups = "contextClick")
    public void handleContextClick() throws InterruptedException, AWTException {
        dashboardScreen.handleContextClick();
    }

    @Test(groups = "dragAndDrop")
    public void handleDragAndDrop() throws InterruptedException {
        dashboardScreen.dragAndDrop();
    }

    @Test(groups = "dropDown")
    public void handleDropDown() throws InterruptedException {
        dashboardScreen.dropDown();
    }

    @Test(groups = "entryAd")
    public void entryAd() throws InterruptedException {
        dashboardScreen.entryAd();
    }

    @Test(groups = "horizontalSlider")
    public void handleHorizontalSlider() throws InterruptedException, AWTException {
        //Pass value between 0 to 5 in multiples of 0.5
        dashboardScreen.horizontalSliderLinkClick();
        dashboardScreen.horizontalSlider(ThreadLocalRandom.current().nextInt(3, 4 + 1));
        dashboardScreen.horizontalSlider(ThreadLocalRandom.current().nextInt(1, 2+1));
    }

    @Test(groups = "jsAlerts")
    public void handleJSAlerts() throws InterruptedException {
        dashboardScreen.handleJSAlerts();
    }

    @Test(groups = "multipleWindows")
    public void multipleWindows() {
        dashboardScreen.multipleWindows();
    }

    @Test(groups = "fileUpload")
    public void fileUpload() throws AWTException {
        dashboardScreen.fileUpload();
    }

    @Test(groups = "enterTextFromFile")
    public void enterTextFromFile() throws IOException {
        dashboardScreen.EnterTextFromFile();
    }
}