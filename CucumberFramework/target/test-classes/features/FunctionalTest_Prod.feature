Feature: Main Website - Functional Test For Production
  In Order to verify Main Functionality
  As I customer of AlgaeCal
  I would like to verify website functionality


  Scenario: HCP Login Page Loads
    Given I navigate to Algaecal.com
    And I navigate to HCP login page for production
    Then I will see all the correct page links for HCP production

  Scenario: HCP Login Page Loads
    Given I navigate to Algaecal.com
    And I navigate to HCP login page for production
    And I log in to HCP for production
    When I check the
    Then I will see all the correct page links for HCP production


