Feature: Validate product images

  Scenario: Validate image loads correctly on product page
    Given the user is on the product details page
    Then the main product image should be displayed
    And the product image is displayed

  Scenario: Validate thumbnails on product page
    Given the user is on the product details page
    When the page displays thumbnail images
    Then each thumbnail should load correctly
    And should display a preview of the product 

  Scenario: Validate image zoom functionality
    Given the user is on the product details page
    When the user hovers over the product image
    Then a zoomed-in version of the image should appear