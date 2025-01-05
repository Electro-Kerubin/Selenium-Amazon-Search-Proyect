package pages;

public class AmazonCartPage extends BasePage {
    
    private String emptyCartMessage = "//h3[@class='a-size-large a-spacing-top-base sc-your-amazon-cart-is-empty']";
    private String productResultSpan = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String amountInput = "//*[@id=\"a-popover-2\"]/div/div/ul";
    private String addProductButton = "//input[@id='add-to-cart-button']";
    private String cartNavButton = "//span[@class='nav-cart-icon nav-sprite']";
    private String removeProductFromCartButton = "//input[@name='submit.delete.7126a6ce-11d0-4e60-b7e0-3ad48ee13d5a']";

    public AmazonCartPage() {
        super(driver);
    }

    public void addProduct(int amount) {
        clickElement(productResultSpan);
        selectFromDropdownByIndex(amountInput, amount);
        clickElement(addProductButton);
    }

    public void removeItemFromCart() {
        clickElement(cartNavButton);
        clickElement(removeProductFromCartButton);
    }

    public String emptyCartMessage() {
        clickElement(cartNavButton);
        return textFromElement(emptyCartMessage);
    }

}
