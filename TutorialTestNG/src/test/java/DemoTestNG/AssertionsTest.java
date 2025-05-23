package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void testingSingleCheckbox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMessage = driver.findElement(By.id("txtAge")).getText();
        softAssert.assertTrue(actualMessage.contains("Checked"),"\n Message Does Not Contain Checked \n");
    }

    @Test
    public void testRadioButtons(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Other']")).click();
        driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        String actualGender =
        driver.findElement(By.cssSelector(".genderbutton")).getText();
        String actualAgeGroup =
        driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        softAssert.assertEquals(actualGender,"Male","\n Actual Gender Is Not Correct \n");
        softAssert.assertTrue(actualAgeGroup.contains("15"), "\n Actual Age Group Is Not Correct \n");
        softAssert.assertAll("\n Test Soft Assert");
    }
}

/* verify Condition(s) via @Test
* assertTrue
* assertFalse                                   Located At the End of @Test
* assertSame                                        assertAll()
* assertNotSame
* assertNotNull
* assertEqual
* */
// There are difference between Hard Assert and Soft Assert
//Hard assert stop the execution.
//Soft assert continues the execution.