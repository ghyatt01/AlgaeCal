@run
Feature: AlgaeCal Add To Cart
  #QA Functional Test - Glen Hyatt - Add to Cart Feature

  Scenario: Verify Add to Cart Button
    Given I enter AlgaeCal.com
    And I navigate to the bone builder packs page
    When I select the add to cart button for 6 monthly supply
    Then I will see that I am on the cart page
    And I will see the bundle adding to the cart


