package pages;

public class AmazonSearchPage extends BasePage {
    
    private String amazonUrl = "https://www.amazon.com/";

    public AmazonSearchPage() {
        super(driver);
    }

    public void navegateToAmazon() {
        navigateTo(amazonUrl);
    }

}
