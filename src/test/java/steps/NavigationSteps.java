package steps;

import io.cucumber.java.en.Given;
import pages.AmazonSearchPage;

public class NavigationSteps {
    
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();

    @Given("the user navigates to www.amazon.com")
    public void navigateToAmazon() {
        amazonSearchPage.navegateToAmazon();
    }


}
