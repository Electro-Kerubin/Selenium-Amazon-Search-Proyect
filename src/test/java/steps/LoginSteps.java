package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import io.cucumber.java.en.Then;

import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("the user enters valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginPage.enterValidUsernameAndPasswordValues();
    }

    @And("the user clicks on the login button")
    public void userClickOnLoginButton() {
        loginPage.clickOnSubmitButton();
    }

    @Then("the user should be redirected to the homepage")
    public void redirectedToTheHomepage() {
        try {
            Assert.assertTrue(loginPage.userIsLogin());
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
        }
        loginPage.logout();
    }

    @When("the user enters invalid username")
    public void userEntersInvalidUsername() {
        // Assert.assertEquals(loginPage.enterInvalidUsername(), "No pudimos encontrar una cuenta con esa dirección de correo electrónico");
        loginPage.enterInvalidUsername();
    }

    @When("the user enters valid username and invalid password")
    public void userEnterValidUsernameAndInvalidPassword() {
        // Assert.assertEquals(loginPage.enterValidUsernameInvalidPasswordMessage(), "La contraseña es incorrecta");
        loginPage.enterValidUsernameInvalidPassword();
    }

    @When("the user leaves the username and password fields empty")
    public void usernameAndPasswordFieldsEmpty() {
        loginPage.enterUsernameAndPasswordFieldsEmpty();
    }
    
    @Then("an email error message should be displayed")
    public void emailErrorMessageDisplayed() {
        Assert.assertEquals(loginPage.emailErrorMessage(), "No pudimos encontrar una cuenta con esa dirección de correo electrónico");
    }

    @Then("an password error message should be displayed")
    public void passwordErrorMessageDisplayed() {
        Assert.assertEquals(loginPage.passwordErrorMessage(), "La contraseña es incorrecta");
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertEquals(loginPage.emptyEmailErrorMessage(), "Escriba su correo electrónico o su número de teléfono móvil");
    }

}
