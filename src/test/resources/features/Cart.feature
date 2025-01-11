Feature: Add products to the cart

    Scenario: Add a single product to the cart
        Given the user is on the product details page
        When the user clicks "Add to Cart"
        Then the cart should display "1 item"

    Scenario: Add multiple products to the cart
        Given the cart is empty
        When the user adds "2 laptops" and "1 mouse" to the cart
        Then the cart should display "3 items"

    Scenario: Validate duplicate products in the cart
        Given the user has added "1 mobile phone" to the cart
        When the user adds the same product again
        Then the cart should display "2 items" and the product quantity should be "2"

    Scenario: Remove a single product from the cart
        Given the cart contains "1 laptop and 1 mouse"
        When the user removes the product "laptop"
        Then the cart should display "1 item" and contain only "1 mouse"

    Scenario: Empty the cart
        Given the cart contains multiple products
        When the user clicks "Empty Cart"
        Then the cart should be empty and display "0 items"

    Scenario: Validate message when trying to remove from an empty cart
        Given the cart is empty
        When the user attempts to remove a product
        Then a message should display "Your cart is empty"

    Scenario: Increase the quantity of a product
        Given the cart contains "1 mobile phone"
        When the user updates the quantity to "3"
        Then the cart should display "3 items" and the subtotal should reflect the price of "3 products"

    Scenario: Decrease the quantity of a product
        Given the cart contains "5 headphones"
        When the user updates the quantity to "2"
        Then the cart should display "2 items" and the subtotal should reflect the price of "2 products"

    Scenario: Set quantity to 0 to remove a product
        Given the cart contains "2 laptops"
        When the user updates the quantity to "0"
        Then the product should be removed from the cart and the cart should display "0 items"

    Scenario: Calculate the subtotal for multiple products
        Given the cart contains "1 laptop for $1000" and "2 headphones for $50 each"
        When the user reviews the cart
        Then the subtotal should be "$1100"

    Scenario: Validate applied discounts in the cart
        Given the cart contains "1 smartphone with a 10% discount applied"
        When the user reviews the cart
        Then the total price of the smartphone should reflect the discount

    Scenario: Validate taxes and grand total
        Given the cart contains products with a subtotal of "$200"
        When the user reviews the total with a "10%" tax
        Then the grand total should be "$220"

    Scenario: Validate persistence after logging out
        Given the user has added "1 laptop and 1 mouse" to the cart
        When the user logs out and logs back in
        Then the cart should still contain "1 laptop and 1 mouse"

    Scenario: Validate persistence across different devices
        Given the user has added "1 smartphone" to the cart from one browser
        When the user logs into their account on another device
        Then the cart should still contain "1 smartphone"