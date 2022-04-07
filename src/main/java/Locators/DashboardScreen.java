package Locators;

import Setup.Setup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class DashboardScreen extends Setup {
    int verifyAddElement=0,verifyDeleteElement;

    @FindBy(linkText = "Basic Auth")
    public WebElement basicAuth;

    @FindBy(id = "content")
    public WebElement basicAuthResult;

    @FindBy(linkText = "Add/Remove Elements")
    public WebElement addRemoveElements;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addElement;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    public List<WebElement> deleteElement;

    @FindBy(xpath="//*[@id = 'content']/h3")
    public WebElement addRemoveElementsPageTitle;

    @FindBy(linkText= "Checkboxes")
    public WebElement checkBoxLink;

    @FindBy(xpath= "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(linkText = "Context Menu")
    public WebElement contextMenu;

    @FindBy(id = "hot-spot")
    public WebElement contextClickElement;

    @FindBy(linkText = "Drag and Drop")
    public WebElement dragAndDrop;

    @FindBy(id = "column-a")
    public WebElement dragA;

    @FindBy(id = "column-b")
    public WebElement dragB;

    @FindBy(linkText = "Dropdown")
    public WebElement dropDownLink;

    @FindBy(id = "dropdown")
    public WebElement dropDown;

    @FindBy(linkText = "Entry Ad")
    public WebElement entryAd;

    @FindBy(xpath = "//div[@class='modal-footer']")
    public WebElement adClose;

    @FindBy(linkText = "Horizontal Slider")
    public WebElement horizontalSliderLink;

    @FindBy(xpath = "//input[@type='range']")
    public WebElement horizontalSlider;

    @FindBy(xpath = "//span[@id='range']")
    public WebElement horizontalSliderValue;

    @FindBy(linkText = "JavaScript Alerts")
    public WebElement jsAlertsLink;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlerts;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPrompt;

    @FindBy(id = "result")
    public WebElement alertResult;

    @FindBy(linkText = "Multiple Windows")
    public WebElement multipleWindows;

    @FindBy(partialLinkText = "Click Here")
    public WebElement clickHere;

    @FindBy(className = "example")
    public WebElement childWindow;

    @FindBy(className = "example")
    public WebElement parentWindow;

    @FindBy(linkText = "File Upload")
    public WebElement fileUpload;

    @FindBy(id = "file-upload")
    public WebElement chooseFile;

    @FindBy(id = "file-submit")
    public WebElement submitUploadedFile;

    @FindBy(xpath = "//div[text()='Upload a file']")
    public WebElement fileUploadGrammarly;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement file;

    @FindBy(linkText = "Forgot Password")
    public WebElement forgotPassword;

    @FindBy(id = "email")
    public WebElement email;

    public void clickBasicAuth() throws AWTException {
        Robot robot = new Robot();
        basicAuth.click();
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        boolean content = basicAuthResult.getText().contains("Congratulations! You must have the proper credentials.");
        if(!content){
            org.testng.Assert.fail("Login failure" + basicAuthResult.getText());
        }
    }
    public void addRemoveElements()  {
        addRemoveElements.click();
       boolean ab = addRemoveElementsPageTitle.getText().equals("Add/Remove Elements");
       if(!ab){
           org.testng.Assert.fail("Title does not match" + addRemoveElementsPageTitle.getText());
       }
        addElement();
        deleteElement();
    }

    void addElement(){
        if(!deleteElement.isEmpty()){
            org.testng.Assert.fail("Delete element should not be displayed");
        }
        addElement.click();
        verifyAddElement++;
        if(verifyAddElement!=deleteElement.size()){
            org.testng.Assert.fail("Element not properly added. No of elements should be " + verifyAddElement);
        }
    }

    void deleteElement()  {
        if(deleteElement.isEmpty()){
            org.testng.Assert.fail("There's no element to remove");
        }
        verifyDeleteElement =deleteElement.size();
        deleteElement.get(0).click();
        verifyDeleteElement--;
        if (verifyDeleteElement!=deleteElement.size()){
            org.testng.Assert.fail("Element not removed properly. The number of elements are " + verifyDeleteElement);
        }
    }

    public void handleCheckBoxes() {
        checkBoxLink.click();
        for(int i=0;i<checkBoxes.size();i++){
            boolean checkBoxStatus = checkBoxes.get(i).isSelected();
            checkBoxes.get(i).click();
            if(checkBoxStatus==checkBoxes.get(i).isSelected()){
                org.testng.Assert.fail("Checkbox status is unchanged even after click");
            }
        }
    }

    public void handleContextClick() throws InterruptedException, AWTException {
        contextMenu.click();
        Actions actions = new Actions(driver);
        actions.contextClick(contextClickElement).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        actions.contextClick().sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
    }

    public void dragAndDrop() throws InterruptedException {
        dragAndDrop.click();
        Actions actions = new Actions(driver);
//        actions.clickAndHold(dragA).moveToElement(dragB).release(dragA).build().perform();
//        actions.dragAndDrop(dragA,dragB).build().perform();
    }

    public void dropDown() throws InterruptedException {
        dropDownLink.click();
        Select select = new Select(dropDown);
        select.selectByIndex(1);
    }

    public void entryAd() throws InterruptedException {
        entryAd.click();
        Thread.sleep(1000);
        adClose.click();
    }

    public void horizontalSliderLinkClick() throws InterruptedException {
        horizontalSliderLink.click();
    }

    public void horizontalSlider(double val) throws InterruptedException, AWTException {
        horizontalSlider.click();
        if(Double.parseDouble(horizontalSliderValue.getText())>val){
            while(Double.parseDouble(horizontalSliderValue.getText())!=val && Double.parseDouble(horizontalSliderValue.getText())>val) {
                horizontalSlider.sendKeys(Keys.LEFT);
            }
        }

        if(Double.parseDouble(horizontalSliderValue.getText())<val){
            while(Double.parseDouble(horizontalSliderValue.getText())!=val && Double.parseDouble(horizontalSliderValue.getText())<val) {
                horizontalSlider.sendKeys(Keys.RIGHT);
            }
        }
    }

    public void handleJSAlerts() throws InterruptedException {
        jsAlertsLink.click();
        jsAlerts.click();
        driver.switchTo().alert().accept();
        boolean result = alertResult.getText().equals("You successfully clicked an alert");
        if (!result){
            org.testng.Assert.fail("Result text is not displayed correctly. It should be " + alertResult.getText());
        }
        jsConfirm.click();
        driver.switchTo().alert().dismiss();
        result = alertResult.getText().equals("You clicked: Cancel");
        if (!result){
            org.testng.Assert.fail("Result text is not displayed correctly. It should be " + alertResult.getText());
        }
        jsConfirm.click();
        driver.switchTo().alert().accept();
        result = alertResult.getText().equals("You clicked: Ok");
        if (!result){
            org.testng.Assert.fail("Result text is not displayed correctly. It should be " + alertResult.getText());
        }
        jsPrompt.click();
        String alertEnterText = "Hello from the other side";
        Alert alert= driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys(alertEnterText);
        alert.accept();
        result = alertResult.getText().equals("You entered: " + alertEnterText );
        if (!result){
            org.testng.Assert.fail("Result text is not displayed correctly. It should be " + alertResult.getText());
        }
    }

    public void multipleWindows() {
        multipleWindows.click();
        clickHere.click();
        if(!childWindow.isDisplayed()){
            org.testng.Assert.fail("Not navigated correctly to the child window");
        }
       String parentWindow =  driver.getWindowHandle();
        Set<String> string = driver.getWindowHandles();
        Iterator<String> iterator = string.iterator();
        driver.switchTo().window(parentWindow);
        if(!this.parentWindow.isDisplayed()){
            org.testng.Assert.fail("Not navigated correctly to the parent window");
        }
    }

    public void fileUpload( ) throws AWTException {

//      file.sendKeys("/Users/meshah/Desktop/test.txt");
        fileUploadGrammarly.click();
        Robot robot = new Robot();
        File file = new File("/Users/meshah/Desktop/test.txt");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);

//Open Goto window

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void EnterTextFromFile() throws IOException {
        forgotPassword.click();
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("/Users/meshah/Desktop/test.txt");
        properties.load(input);
        email.sendKeys(properties.getProperty("email"));
    }

}
