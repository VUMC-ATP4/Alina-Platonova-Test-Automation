package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebsiteTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setupBrowser() {
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void checkPageTitleOne() {
        String url = "https://www.deepl.com/";
        driver.get(url);
        String expectedTitle = "DeepL Translate: The world's most accurate translator";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void checkPageTitleTwo() {
        String url = "https://www.youtube.com/";
        driver.get(url);
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Pēc testa");
        driver.quit();
    }

}
