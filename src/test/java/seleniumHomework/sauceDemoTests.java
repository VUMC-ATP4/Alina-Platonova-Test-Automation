package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.time.Duration;

public class sauceDemoTests {

    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void firstScenario() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        cartPage.addTshirtToCart().click();
        Thread.sleep(3000);

        cartPage.goToCart().click();
        Thread.sleep(3000);

        Assert.assertEquals(cartPage.findProduct().getText(), "Sauce Labs Bolt T-Shirt");

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout().click();
        Thread.sleep(3000);

        checkoutPage.getFirstNameInputField().sendKeys("Alīna");
        checkoutPage.getLastNameInputField().sendKeys("Platonova");
        checkoutPage.getZipCodeInputField().sendKeys("1234");
        Thread.sleep(3000);

        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getPageTitle().getText(), "CHECKOUT: OVERVIEW");

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        checkoutSuccessPage.getFinishButton().click();
        Thread.sleep(3000);

        Assert.assertEquals(checkoutSuccessPage.getCheckoutComplete().getText(), "THANK YOU FOR YOUR ORDER");

        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(3000);
    }

    @Test
    public void secondScenario() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart().click();
        Thread.sleep(3000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout().click();
        Thread.sleep(3000);

        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);

        Assert.assertEquals(checkoutPage.getErrorText().getText(), "Error: First Name is required");

        checkoutPage.getFirstNameInputField().sendKeys("Alīna");
        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);

        Assert.assertEquals(checkoutPage.getErrorText().getText(), "Error: Last Name is required");

        checkoutPage.getLastNameInputField().sendKeys("Platonova");
        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);

        Assert.assertEquals(checkoutPage.getErrorText().getText(), "Error: Postal Code is required");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
