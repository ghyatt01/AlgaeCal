@smoke
Feature: Main Website - Create Order
  In Order to verify Order Submission
  As I customer of AlgaeCal
  I would like to verify an order can be created


  Scenario Outline: 01 - Order AlgaeCal Products From Main Stage Website With Canada Address
    Given I navigate to Stage.Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete "canada" checkout and place my order in stage environment with a test credit card ending in "5556"
    Then I should see the order confirmation page in stage for "<product>"
    And I should see the IDK ID returned after the order is submitted for "<product>" in stage
    And I should see correct e-commerce datalayer tracking information for "<product>" on confirmation page
    And I do not select an upsell for "<product>"
    And I should see the order reflected in BigCommerce

  Examples:
    |product                       |
   # |Bone Builder Pack             |
    |AlgaeCal Plus                |
    |Strontium Boost              |
   # |AlgaeCal Basic               |
   # |Triple Power Omega 3 Fish Oil|
   # |Omega 3 Blood Test Kit       |


  Scenario Outline: 02 - Order AlgaeCal Products From Main Stage Website With USA Address
    Given I navigate to Stage.Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete "<usa>" checkout and place my order in stage environment with a test credit card ending in "<5555>"
    Then I should see the order confirmation page in stage for "<product>"
    And I should see the IDK ID returned after the order is submitted for "<product>" in stage
    And I should see correct e-commerce datalayer tracking information for "<product>" on confirmation page
    And I do not select an upsell for "<product>"
    And I should see the order reflected in BigCommerce

    Examples:
      |product                       |
   #   |Bone Builder Pack             |
    #  |AlgaeCal Plus                |
    #  |Strontium Boost              |
    #  |AlgaeCal Basic               |
    #  |Triple Power Omega 3 Fish Oil|
    #  |Omega 3 Blood Test Kit       |

  Scenario Outline: 03 - Order AlgaeCal Products From Main Stage Website With International Address
    Given I navigate to Stage.Algaecal.com
    And I set the browser geolocation to an international location
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete canada checkout and place my order in stage environment
    Then I should see the order confirmation page in stage for "<product>"
    And I should see the IDK ID returned after the order is submitted for "<product>" in stage
    And I should see correct e-commerce datalayer tracking information for "<product>" on confirmation page
    And I do not select an upsell for "<product>"
    And I should see the order reflected in BigCommerce

    Examples:
      |product                       |
   #   |Bone Builder Pack             |
   #   |AlgaeCal Plus                |
   #   |Strontium Boost              |
   #   |AlgaeCal Basic               |
   #   |Triple Power Omega 3 Fish Oil|
   #   |Omega 3 Blood Test Kit       |


  Scenario Outline: 04 - Order AlgaeCal Products From Main Stage Website With Canada Address with Sezzle
    Given I navigate to Stage.Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete canada checkout and place my order in stage environment with sezzle
    Then I should see the order confirmation page in stage for "<product>"
    And I do not select an upsell for "<product>"
    And I should see the order reflected in BigCommerce

    Examples:
      |product                       |
  #    |Bone Builder Pack             |
  #  |AlgaeCal Plus                |
  #  |Strontium Boost              |
  #  |AlgaeCal Basic               |
  #  |Triple Power Omega 3 Fish Oil|
  #  |Omega 3 Blood Test Kit       |