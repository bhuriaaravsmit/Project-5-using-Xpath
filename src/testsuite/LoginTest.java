package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setup()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){

        //click on the Signin link
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();

        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Verify the text", expectedText, actualText);

    }

    @Test
public void verifyTheErrorMessage(){
        //click on the Signin link
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();

        //Error message
        driver.findElement(By.id("user[email]")).sendKeys("test@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("NewTesting");

        driver.findElement(By.xpath("//button[@class ='button button-primary g-recaptcha']")).click();
        String expectedText= "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class ='form-error__list-item']")).getText();
        System.out.println(actualText);

        Assert.assertEquals("Verify the text", expectedText, actualText);

    }



    @After
    public void tearDown(){
        //closeBrowser();
    }
}



