package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class AmazonSearchPage extends BasePage {
    
    private String amazonUrl = "https://www.amazon.com/";
    private String searchTextBox = "//input[@id='twotabsearchtextbox']";
    private String searchSubmitButton = "//input[@id='nav-search-submit-button']";
    private String firstItem = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String thirdItem = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[6]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    private String resultsMessage = "//h2[@class='a-size-medium-plus a-spacing-none a-color-base a-text-bold']";
    private String searchSuggestions = "//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion']";
    private String firstSearchSuggestions = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]";
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

    public String getFirstProductName() {
        return textFromElement(firstItem);
    } 

    public String resultMessage() {
        return textFromElement(resultsMessage);
    }

    public void typingInSearchBar(String item) {
        write(searchTextBox, item);
    }

    public List<String> listOfSuggestionSearch() {

        System.out.println(textFromElement(firstSearchSuggestions));

        List<WebElement> listSearchSuggestions = bringMeAllElements(searchSuggestions);
        List<String> suggestions = new ArrayList<>();
        System.out.println(textFromElement(firstSearchSuggestions));
        System.out.println("ElementsByXpath = " + listSearchSuggestions);

        for (WebElement suggestion : listSearchSuggestions) {
            System.out.println("test: " + suggestion.getText().toLowerCase().trim());
            suggestions.add(suggestion.getText().toLowerCase().trim());
        }
        System.out.println("Suggestions products: " + suggestions);
        return suggestions;
    }

    public void clickSearchButton() {
        clickElement(searchSubmitButton);
    }

    public String actualUrl() {
        return driver.getCurrentUrl();
    }

}
