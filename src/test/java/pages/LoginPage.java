package pages;

public class LoginPage extends BasePage {

    private String loginNavLink = "//span[@id='nav-link-accountList-nav-line-1']";
    private String continuarBtn = "//input[@id='continue']";
    private String emailInput = "//input[@id='ap_email']";
    private String passwordInput = "//input[@id='ap_password']";
    private String loginSubmitBtn = "//input[@id='signInSubmit']";
    private String homeLoginMenuText = "//h1[normalize-space()='Tu cuenta']";
    private String emailErrorMessage = "//div[@class='a-section a-spacing-base auth-pagelet-container']//div[@class='a-box-inner a-alert-container']//div[1]";
    private String passwordErrorMessage = "//div[@class='a-section a-spacing-base auth-pagelet-container']//div[@class='a-box-inner a-alert-container']//div[1]";
    private String emptyErrorMessage = "//div[@class='a-alert-content'][normalize-space()='Escriba su correo electrónico o su número de teléfono móvil']";

    private String logoutButton = "//span[normalize-space()='Cerrar Sesión']";

    public LoginPage() {
        super(driver);
    }
    
    public void navigateToLoginPage() {
        navigateTo("https://www.amazon.com/-/es/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Flanguage%3Des_US%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        //clickElement(loginNavLink);
        //clickElement(emailInput);
    } 

    public void enterValidUsernameAndPasswordValues() {
        write(emailInput, "rbcirano.social@gmail.com");
        clickElement(continuarBtn);
        write(passwordInput, "Contraseñatest123");
    }

    public void clickOnSubmitButton() {
        clickElement(loginSubmitBtn);
    }

    public boolean userIsLogin() {
        clickElement(loginNavLink);
        return textFromElement(homeLoginMenuText).trim().contains("Tu cuenta");
    }

    public void logout() {
        hoverOverElement(loginNavLink);
        clickElement(logoutButton);
        navigateTo("https://www.amazon.com/?language=es_US");
    }

    public void enterInvalidUsername() {
        write(emailInput, "invalidemail1@email.com");
        clickElement(continuarBtn);
        // return textFromElement(emailErrorMessage).trim();
    }

    public void enterValidUsernameInvalidPassword() {
        write(emailInput, "rbcirano.social@gmail.com");
        clickElement(continuarBtn);
        write(passwordInput, "wrongpassword123");
        // return textFromElement(passwordErrorMessage).trim();
    }

    public void enterUsernameAndPasswordFieldsEmpty() {
        write(emailInput, "");
        clickElement(continuarBtn);
    }

    public String emailErrorMessage() {
        return textFromElement(emailErrorMessage).trim();
    }

    public String passwordErrorMessage() {
        return textFromElement(passwordErrorMessage).trim();
    }

    public String emptyEmailErrorMessage() {
        return textFromElement(emptyErrorMessage).trim();
    }

}
