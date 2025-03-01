package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class AmazonSearchPage extends BasePage {
    
    private String amazonUrl = "https://www.amazon.com/?language=es_US";
    private String searchTextBox = "//input[@id='twotabsearchtextbox']";
    private String searchSubmitButton = "//input[@id='nav-search-submit-button']";
    private String firstItem = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String thirdItem = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[6]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String resultsMessage = "//span[normalize-space()='Sin resultados para']";
    private String addToCartButton = "//input[@id='add-to-cart-button']";
    private String addItemToCartMessage = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/h1";

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

    public void goToFirstProduct() {
        clickElement(firstItem);
    }

    public void goToSecondPage(String pageNumber) {
        goToLinkText(pageNumber);
    }

    public void addThirdItemToCart() {
        clickElement(thirdItem);
        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addItemToCartMessage);
    }

    public boolean isProductInSearchResults(String product) {
        List<WebElement> results = getResultListAmazonPage("searchResult");
        List<String> resultsNames = new ArrayList<>();

        for(WebElement result: results) {
            resultsNames.add(result.getText().trim());
        }

        boolean found = resultsNames.stream().anyMatch(name -> name.toLowerCase().contains(product.toLowerCase()));
        return found;
    }

    public boolean resultMessage() {
        return textFromElement(resultsMessage).trim().contains("Sin resultados");
    }

    public void typingInSearchBar(String item) {
        write(searchTextBox, item);
        clickElement(searchTextBox);
    }

    public void clickSearchButton() {
        clickElement(searchSubmitButton);
    }

    public String actualUrl() {
        return driver.getCurrentUrl();
    }

}
