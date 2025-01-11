Feature: Validate dynamic content on search results

  Scenario: Validate product images in search results
    Given the user is on the search results page
    When the page loads
    Then each product in the results should have a valid image

  Scenario: Validate product titles and descriptions
    Given the user is on the search results page
    When the page displays product details
    Then each product should have a title and a short description

  Scenario: Validate content refresh on scroll
    Given the user is on the search results page
    And the page supports infinite scrolling
    When the user scrolls down
    Then new products should load dynamically
    And each product should have valid images and titles