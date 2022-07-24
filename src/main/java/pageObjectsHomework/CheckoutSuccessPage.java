package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    private By finishButton = By.id("finish");
    private By checkoutComplete = By.cssSelector("div[id='checkout_complete_container'] h2[class='complete-header']");
    private By backHomeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }

    public WebElement getCheckoutComplete() {
        return driver.findElement(checkoutComplete);
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButton);
    }

}
