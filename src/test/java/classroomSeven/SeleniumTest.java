package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import java.time.Duration;
import java.util.List;


public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser() {
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void localHTMLExerciseTest() throws InterruptedException {
        driver.get("file://C:\\Users\\Ali\\IdeaProjects\\Alina-Platonova-Test-Automation\\src\\test\\resources\\elements.html");
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys("Šis ir mans teksts par mani. Hey!");
        WebElement linkElement = driver.findElement(By.linkText("Link Text"));
        linkElement.click();
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
        Assert.assertEquals(isStudentCheckbox.isSelected(), false);
        isStudentCheckbox.click();
        Assert.assertEquals(isStudentCheckbox.isSelected(), true);
        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);
        milakaKrasa.selectByIndex(3);
        List<WebElement> sarakstsArKrasam = milakaKrasa.getOptions();

        for (int i = 0; i < sarakstsArKrasam.size(); i++) {
            System.out.println(sarakstsArKrasam.get(i));
        }

        WebElement nospiedManiPoga = driver.findElement(By.id("checkDataID"));
        nospiedManiPoga.click();

        WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
        wait.until(ExpectedConditions.elementToBeClickable(vissIrLabiTeksts));
        vissIrLabiTeksts.click();

    }

    @Test
    public void successFullLoginText() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByValue("hilo");
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByIndex(1);

        WebElement linkedinLink = driver.findElement(By.linkText("LinkedIn"));
        linkedinLink.click();

        Thread.sleep(5000);


    }

    @Test
    public void errorMessagePasswordEmptyPageObjectTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.getUsernameInputField().sendKeys("Alina");
        //loginPage.getPasswordInputField().sendKeys("");
        //loginPage.getLoginButton().click();
        loginPage.login("Alīna","");
        Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Password is required");
    }

    @Test
    public void errorMessageUsernameEmptyPageObjectTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("");
        loginPage.getPasswordInputField().sendKeys("123");
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Username is required");
    }

    @Test
    public void successLoginPageObject() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        inventoryPage.getLinkedinLink().click();
        Thread.sleep(5000);
    }


    @Test
    public void errorMessagePasswordEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELABS_URL);
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("Alina");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        //errorText.getText();
        Assert.assertEquals(errorText.getText(), "Epic sadface: Password is required");
        //Thread.sleep(5000);
    }

    @Test
    public void errorMessageUsernameEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELABS_URL);
        WebElement acceptedUsername = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptedUsername.getText());
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("123");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username is required";
        Assert.assertEquals(actualText, expectedText);
        //Thread.sleep(5000);
    }

    @Test
    public void errorMessageUsernameAndPasswordEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELABS_URL);
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username is required";
        Assert.assertEquals(actualText, expectedText);
        //Thread.sleep(5000);
    }

    @Test
    public void errorMessageWrongCredentials() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELABS_URL);
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("Alina");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("qwerty123");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualText, expectedText);
    }


    @Test
    public void myTest2() {
        System.out.println("TESTS");
        driver.get("https://www.delfi.lv/");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Pēc testa");
        driver.quit();
    }


}
