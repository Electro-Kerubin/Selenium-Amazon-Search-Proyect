package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonCartPage;
import pages.AmazonSearchPage;

public class AmazonCartSteps {
    
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();
    AmazonCartPage amazonCartPage = new AmazonCartPage();

    @Given("the user has added (.+)$ to the cart")
    public void userAddProductToCart(String product) {
        // amazonSearchPage.navegateToAmazon();
        amazonSearchPage.searchProduct(product);
        amazonCartPage.addProduct(1);

        Assert.assertEquals("Agregado al carrito", amazonSearchPage.addedToCartMessage());
    }

    @When("the user removes the item from the cart")
    public void removeItemFromCart() {
        amazonCartPage.removeItemFromCart();
    }

    @Then("the cart should be empty")
    public void cartShouldBeEmpty() {
        Assert.assertEquals("Tu carrito de Amazon está vacío", amazonCartPage.emptyCartMessage());
    }

}
