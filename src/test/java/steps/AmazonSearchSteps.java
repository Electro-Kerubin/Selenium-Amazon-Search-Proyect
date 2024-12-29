package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {
    
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();

    @Given("the user navigates to www.amazon.com")
    public void navigateToAmazon() {
        amazonSearchPage.navegateToAmazon();
    }

    @And("searches for (.+)$")
    public void searchesForProduct(String product) {
        amazonSearchPage.searchProduct(product);
    }

    @And("navigates to the second page")
    public void navigatesToSecondPage() {
        amazonSearchPage.goToSecondPage("2");
    }

    @And("selects the third item")
    public void selectTheThirdItem() {
        amazonSearchPage.addThirdItemToCart();
    }

    @Then("the user would be able to add it to the cart")
    public void itemCanBeAbleToTheCart() {
        Assert.assertEquals("Agregado al carrito", amazonSearchPage.addedToCartMessage());
    }
}
