@SearchFunctionality
Feature: Test Amazon search functionality

    @SearchListOfProducts
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

    @SearchExactProduct
    Scenario: Search with exact product match
        Given the user navigates to www.amazon.com
        When the user searches for "Amazon Echo Dot"
        Then the search results should show items relevant to "Amazon Echo Dot"

    @SearchWitchNoResults
    Scenario: Search with no results
        Given the user navigates to www.amazon.com
        When the user searches for "NonExistentProduct12345"
        Then the user should see a message indicating no results were found

    @SearchWithProductSuggestions
    Scenario: Search with product suggestions
        Given the user navigates to www.amazon.com
        When the user starts typing "Alex"
        Then the search bar should show suggestions including "Alexa"

    @SearchWithEmptyQuery
    Scenario: Search with an empty query
        Given the user navigates to www.amazon.com
        When the user clicks the search button without entering any text
        Then the user should see a prompt to enter a search term
