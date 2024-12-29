package pages;

public class AmazonSearchPage extends BasePage {
    
    private String amazonUrl = "https://www.amazon.com/";
    private String searchTextBox = "//input[@id='twotabsearchtextbox']";
    private String searchSubmitButton = "//input[@id='nav-search-submit-button']";
    private String paginatorSecondPage = "//a[@aria-label='Ir a la página 2']";
    private String thirdItem = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[6]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String addToCartButton = "//input[@id='add-to-cart-button']";
    private String addItemToCartMessage = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']";

    public AmazonSearchPage() {
        super(driver);
    }

    public void navegateToAmazon() {
        navigateTo(amazonUrl);
    }

    public void searchProduct(String item) {
        write(searchTextBox, item);
        clickElement(searchSubmitButton);
    }

    public void goToSecondPage() {
        clickElement(paginatorSecondPage);
    }

    public void addThirdItemToCart() {
        clickElement(thirdItem);
        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addItemToCartMessage);
    }

}
