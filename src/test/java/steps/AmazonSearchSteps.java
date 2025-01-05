package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("the search results should show items relevant to (.+)$")
    public void searchResultsShouldShowItems(String product) {
        Assert.assertEquals(product, amazonSearchPage.getFirstProductName());
    }

    @Then("the user should see a message indicating no results were found")
    public void noResultsFound() {
        Assert.assertNotSame("Resultados", amazonSearchPage.resultMessage());
    }

    @When("the user starts typing (.+)$")
    public void userTypingProduct(String product) {
        amazonSearchPage.typingInSearchBar(product);
    }

    // Arreglar el siguiente método
    // @Then("the search bar should show suggestions including (.+)$")
    public void searchSuggestions(String product) {
        Assert.assertTrue(amazonSearchPage.listOfSuggestionSearch().contains(product));
    }

    @When("the user clicks the search button without entering any text")
    public void userClickSearchButtonEmpty() {
        amazonSearchPage.clickSearchButton();
    }

    @Then("the user should see a prompt to enter a search term")
    public void promptToEnterSearchTerm() {

        Assert.assertEquals("https://www.amazon.com/", amazonSearchPage.actualUrl());
    }

}
