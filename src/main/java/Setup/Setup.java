package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup  {
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void set() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod(alwaysRun = true)
    public void test() {

        driver.get("http://the-internet.herokuapp.com/");

    }

    @AfterClass(alwaysRun = true)
    public void closure() {
        driver.close();
        driver.quit();
    }

    public Setup() {
        PageFactory.initElements(driver, this);
    }

}