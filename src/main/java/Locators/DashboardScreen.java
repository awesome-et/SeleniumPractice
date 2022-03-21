package Locators;

import Setup.Setup;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class DashboardScreen extends Setup {
    int verifyAddElement=0,verifyDeleteElement;

    @FindBy(linkText = "Basic Auth")
    public WebElement basicAuth;

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

    void clickBasicAuth() {
        basicAuth.click();
    }
    void addRemoveElements()  {
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

    void handleCheckBoxes() {
        checkBoxLink.click();
        for(int i=0;i<checkBoxes.size();i++){
            boolean checkBoxStatus = checkBoxes.get(i).isSelected();
            checkBoxes.get(i).click();
            if(checkBoxStatus==checkBoxes.get(i).isSelected()){
                org.testng.Assert.fail("Checkbox status is unchanged even after click");
            }
        }
    }

    void handleContextClick() throws InterruptedException {
        contextMenu.click();
        Actions actions = new Actions(driver);
        actions.contextClick(contextClickElement).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    void dragAndDrop() throws InterruptedException {
        dragAndDrop.click();
        Actions actions = new Actions(driver);
//        actions.clickAndHold(dragA).moveToElement(dragB).release(dragA).build().perform();
        actions.dragAndDrop(dragA,dragB).build().perform();
    }

    void dropDown() throws InterruptedException {
        dropDownLink.click();
        Select select = new Select(dropDown);
        select.selectByIndex(1);
    }

    void entryAd() throws InterruptedException {
        entryAd.click();
        Thread.sleep(5000);
        adClose.click();
    }

    void horizontalSliderLinkClick() throws InterruptedException {
        horizontalSliderLink.click();
    }

    void horizontalSlider(double val) throws InterruptedException, AWTException {
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
}
