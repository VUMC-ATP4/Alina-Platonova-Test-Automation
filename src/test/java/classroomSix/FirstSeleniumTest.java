package classroomSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void checkPageTitle() {
        String url = "https://www.saucedemo.com/";
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get(url);
        String expectedTitle = "Swag Labs";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        chromeBrowser.quit();
    }

}
