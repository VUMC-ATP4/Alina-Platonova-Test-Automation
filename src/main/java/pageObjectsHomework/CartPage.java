package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;

    private By addTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By cartButton = By.className("shopping_cart_link");
    private By productName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addTshirtToCart() {
        return driver.findElement(addTshirt);
    }

    public WebElement goToCart() {
        return driver.findElement(cartButton);
    }

    public WebElement findProduct() {
        return driver.findElement(productName);
    }

}
