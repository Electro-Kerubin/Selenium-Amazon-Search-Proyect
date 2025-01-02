@InterfacesValidation
Feature: Interface validation functionality

    Scenario: Validate product details page
        Given the user navigates to the details page of "Alexa"
        Then the page should display the product title, price, and "Add to Cart" button

    Scenario: Navigate through the departments menu
        Given the user hovers over the "Departments" menu
        When the user selects "Electronics"
        Then the user should be taken to the Electronics category page