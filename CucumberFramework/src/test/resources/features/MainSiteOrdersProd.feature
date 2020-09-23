Feature: Main Website - Create Order
  In Order to verify Order Submission
  As I customer of AlgaeCal
  I would like to verify an order can be created

  Scenario Outline: Order AlgaeCal Products From Main Production Website With Canada Address
    Given I navigate to Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete canada checkout and place my order in production
    Then I should see the order confirmation page in prod for "<product>"
    And I should see the IDK ID returned after the order is submitted for "<product>" in prod
    And I should see correct e-commerce datalayer tracking information for "<product>" on confirmation page
    And I do not select an upsell for "<product>"
    And I should see the order reflected in BigCommerce

  Examples:
    |product                       |
    |Bone Builder Pack             |
    |AlgaeCal Plus                |
    |Strontium Boost              |
    |AlgaeCal Basic               |
    |Triple Power Omega 3 Fish Oil|
    |Omega 3 Blood Test Kit       |

  Scenario Outline: Order AlgaeCal Products From Main Production Website With USA Address
    Given I navigate to Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete USA checkout and place my order in production
    Then I should see the order confirmation page
    And I should see the order reflected in BigCommerce

    Examples:
    |product                       |
    |Bone Builder Pack             |
    |AlgaeCal Plus                |
    |Strontium Boost              |
    |AlgaeCal Basic               |
    |Triple Power Omega 3 Fish Oil|
    |Omega 3 Blood Test Kit       |

  Scenario Outline: Order AlgaeCal Products From Main Production Website With International Address
    Given I navigate to Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete canada checkout and place my order in production
    Then I should see the order confirmation page
    And I should see the order reflected in BigCommerce

    Examples:
      |product                       |
      |Bone Builder Pack             |
      |AlgaeCal Plus                |
      |Strontium Boost              |
      |AlgaeCal Basic               |
      |Triple Power Omega 3 Fish Oil|
      |Omega 3 Blood Test Kit       |

  Scenario Outline: Order AlgaeCal Products From Main Production Website With Canada Address with Sezzle
    Given I navigate to Algaecal.com
    And I navigate to the products page
    And I select the "<product>" product
    And I select the supply amount for the "<product>"
    And I verify the cart is accurate for "<product>"
    When I complete canada checkout and place my order in production with sezzle
    Then I should see the order confirmation page
    And I should see the order reflected in BigCommerce

    Examples:
      |product                       |
      |Bone Builder Pack             |
      |AlgaeCal Plus                |
      |Strontium Boost              |
      |AlgaeCal Basic               |
      |Triple Power Omega 3 Fish Oil|
      |Omega 3 Blood Test Kit       |

