@SearchFunctionality
Feature: Test Amazon search functionality

    @SearchListOfProducts
    Scenario Outline: As a Customer when I search for a product, I want to see if the third option on the second page is available for purchase and can be added to the cart.
        And searches for <Product>
        And navigates to the second page
        And selects the third item
        Then the user would be able to add it to the cart

        Examples:
            | Product     |
            | Alexa       |
            | Playstation |

    @SearchExactProduct
    Scenario Outline: Search with exact product match
        Given the user navigates to www.amazon.com
        And searches for <Product>
        Then the search results should show items relevant to <Product>

        Examples:
            | Product                               |
            | Echo Pop con bombilla WiZ Smart Color |
            | PlayStation 2 Slim Console PS2        |

    @SearchWitchNoResults
    Scenario: Search with no results
        Given the user navigates to www.amazon.com
        And searches for "NonExistentProduct12345"
        Then the user should see a message indicating no results were found