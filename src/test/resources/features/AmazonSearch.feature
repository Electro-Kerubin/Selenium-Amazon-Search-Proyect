@Amazon
Feature: Test Amazon search functionality

    @Cart
    Scenario Outline: As a Customer when I search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart.
    Given the user navigates to www.amazon.com
    And searches for <Product>
    And navigates to the second page
    And selects the third item
    Then the user would be able to add it to the cart

    Examples:
        | Product     |
        | Alexa       |
        | Playstation |