package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;
    private By pageTitle = By.cssSelector("div[id='header_container'] span[class='title']");
    private By linkedInLink = By.linkText("LinkedIn");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }

    public WebElement getLinkedinLink() {
        return driver.findElement(linkedInLink);
    }


}
