package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AcodemyShop.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;
    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv/";

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        System.out.println("Pirms testa");
        driver = new ChromeDriver();

//        FirefoxOptions browserOptions = new FirefoxOptions();
//        browserOptions.setCapability("platformName", "Windows 11");
//        browserOptions.setCapability("browserVersion", "latest");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("screenResolution", "2560x1600");
//        sauceOptions.put("build", "Alina Test 123");
//        sauceOptions.put("name", "Regession Test 2");
//        browserOptions.setCapability("sauce:options", sauceOptions);

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "103");
//        chromeOptions.setCapability("platformName", "Windows");
//        chromeOptions.setCapability("se:name", "My simple test");
        //driver = new RemoteWebDriver(new URL("https://oauth-aliina.platonova-8a12a:2eba8807-e9bd-454b-b921-c4b323b5316e@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
        //driver = new RemoteWebDriver(new URL("https://oauth-aliina.platonova-8a12a:2eba8807-e9bd-454b-b921-c4b323b5316e@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), ChromeOptions);
        //driver = new RemoteWebDriver(new URL("http://192.168.1.61:4444/"), chromeOptions);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void searchForItemTest() throws InterruptedException {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        System.out.println("Search results count: " + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 2);
        List<WebElement> searchResults = mainPage.getSearchResults();
        for (WebElement element : searchResults) {
            System.out.println(element.findElement(By.cssSelector("h2")).getText());
        }

        Thread.sleep(5000);
    }

    @Test
    public void searchForItemTestTwo() throws InterruptedException {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("hoodie");
        System.out.println("Search results count: " + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 3);
        Thread.sleep(5000);
    }

    @Test
    public void switchTabsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/");
        System.out.println("Atvērti tabi: " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By .cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atvērti tabi: " + driver.getWindowHandles().size());
        Thread.sleep(5000);
        System.out.println();
    }

    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();

        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        WebElement menu = driver.findElement(By.className("menuContainer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", menu);
        Thread.sleep(2000);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement hoverMeButton = driver.findElement(By.cssSelector("div.dropdown2 button"));

        new Actions(driver)
                .moveToElement(hoverMeButton)
                        .perform();

        Thread.sleep(5000);
        driver.findElement(By.linkText("Link 1")).click();

    }

    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        Thread.sleep(5000);
        driver.findElement(By.id("clickToUseButton")).click();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .sendKeys("J")
                .sendKeys("U")
                .sendKeys("R")
                .sendKeys("I")
                .sendKeys("S")
                .perform();

        Thread.sleep(5000);
    }

    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);

        driver.findElement(By.id("docsearch-input")).sendKeys("Selenium");
        Thread.sleep(3000);

    }


    @AfterMethod
    public void tearDown() {
        System.out.println("Pēc testa");
        driver.quit();
    }

}
