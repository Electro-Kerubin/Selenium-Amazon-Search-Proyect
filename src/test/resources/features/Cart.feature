@CartFunctionality
Feature: Amazon Cart Functionality

    Scenario Outline: Remove an item from the cart
        Given the user has added <Product> to the cart
        When the user removes the item from the cart
        Then the cart should be empty

        Examples:
            | Product |
            | Alexa   |

    Scenario Outline: Update the quantity of an item in the cart
        Given the user has added <Product> to the cart
        When the user updates the quantity to 2
        Then the cart should show 2 units of <Product>

        Examples:
            | Product |
            | Alexa   |

    Scenario Outline: Validate total price in the cart
        Given the user has added <Product> to the cart
        And the user updates the quantity to 3
        Then the total price should reflect the price of 3 units

    Scenario: Add an out-of-stock item to the cart
        Given the user navigates to the page of an out-of-stock item
        When the user attempts to add the item to the cart
        Then the user should see a message indicating the item is not available

    Scenario Outline: Add an item to the cart without logging in
        Given the user navigates to www.amazon.com
        When the user adds <Product> to the cart
        Then the user should be able to see the item in the cart without logging in

        Examples:
            | Product |
            | Alexa   |

    Scenario Outline: Cart persistence after login
        Given the user adds <Product> to the cart while not logged in
        When the user logs in with valid credentials
        Then the item should still be in the cart

        Examples:
            | Product |
            | Alexa   |