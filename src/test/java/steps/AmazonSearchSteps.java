package steps;


import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AmazonCartPage;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {
    
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();
    AmazonCartPage amazonCartPage = new AmazonCartPage();

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

    @Then("the search results should show items relevant to (.+)$")
    public void searchResultsShouldShowItems(String product) {
        Assert.assertTrue(amazonSearchPage.isProductInSearchResults(product));
        // Assert.assertEquals(product, amazonSearchPage.getResultsNames());
    }

    @Then("the user should see a message indicating no results were found")
    public void noResultsFound() {
        Assert.assertTrue(amazonSearchPage.resultMessage());
        //Assert.assertNotSame("Resultados", amazonSearchPage.resultMessage());
    }

    // @When("the user starts typing (.+)$")
    // public void userTypingProduct(String product) {
    //     amazonSearchPage.typingInSearchBar(product);
    // }

    @Given("the user has added {string} to the cart")
    public void userAddProductToCart(String product) {
        amazonSearchPage.searchProduct(product);
        amazonCartPage.addProduct(1);

        Assert.assertEquals("Agregado al carrito", amazonSearchPage.addedToCartMessage());
    }

}
