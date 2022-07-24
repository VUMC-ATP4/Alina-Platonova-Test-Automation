package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;

    private By pageTitle = By.cssSelector("div[id='header_container'] span[class='title']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }

}
