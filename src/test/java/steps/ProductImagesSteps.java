package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearchPage;
import pages.ProductDetailPage;

public class ProductImagesSteps {

    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Given("the user is on the product details page")
    public void userIsOnProductDetailsPage() {
        amazonSearchPage.searchProduct("Alexa");
        amazonSearchPage.goToFirstProduct();
        System.out.println("Product title: " + productDetailPage.productTitle());
        Assert.assertTrue(productDetailPage.productTitle().contains("Alexa"));
    }

    @Then("the main product image should be displayed")
    public void mainProductImageIsDisplayed() {
        
    }

    @And("the product image is displayed")
    public void imageURLIsNotBroken() {
        Assert.assertTrue(productDetailPage.checkImage());
    }

    @When("the page displays thumbnail images")
    public void pageDisplaysThumbnailImages() {
        Assert.assertTrue(productDetailPage.checkImage());
    }

    @Then("each thumbnail should load correctly")
    public void thePageDisplaysThumbnailImages() {
        productDetailPage.validateThumbnails();
    }

    @And("should display a preview of the product")
    public void shouldDisplayAPreviewOfTheProduct() {
        productDetailPage.validateThumbnails();
    }
}
