package classroomSeven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SeleniumTest {

    @Test
    public void myTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


}
