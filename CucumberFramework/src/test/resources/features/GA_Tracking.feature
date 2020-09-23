Feature: GA Tracking
  In order to validate the correct GA tracking
  As An Internal User of AlgaeCal
  I wish to compare specific data points


  Scenario Outline: Adroll Products Validation - Production Chrome
    Given I navigate to the production URL of "<url>" for datalayer tracking
    When I validate the product IDs from data layer for "<url>"
    Then I will see the correct product IDs for "<url>"

    Examples:
      |url|
  |https://www.algaecal.com/sp/apsb6a/us/dp/cs/natural-calcium/       |
  |https://www.algaecal.com/sp/apsb12a/sp/                            |
  |https://www.algaecal.com/products/bone-builder-pack-1-month-supply/ |
  |https://www.algaecal.com/products/bone-builder-pack-3-month-supply/|
  |https://www.algaecal.com/products/bone-builder-pack-6-month-supply/|
  |https://www.algaecal.com/products/algaecal-plus-1-month-supply/    |
  |https://www.algaecal.com/products/algaecal-plus-3-month-supply/    |
  |https://www.algaecal.com/products/algaecal-plus-6-month-supply/    |
  |https://www.algaecal.com/products/algaecal-basic-1-month-supply/   |
  |https://www.algaecal.com/products/algaecal-basic-3-month-supply/   |
  |https://www.algaecal.com/products/strontium-boost-1-month-supply/  |
  |https://www.algaecal.com/products/strontium-boost-3-month-supply/  |
  |https://www.algaecal.com/products/strontium-boost-6-month-supply/  |
  |https://www.algaecal.com/products/triple-power-omega-3-fish-oil-1-bottle/      |
  |https://www.algaecal.com/products/triple-power-omega-3-fish-oil-3-month-supply/|
  |https://www.algaecal.com/products/triple-power-omega-3-fish-oil-6-month-supply/|
  |https://www.algaecal.com/product/bone-builder-packs/                           |
  |https://www.algaecal.com/product/algaecal-plus/                                |
  |https://www.algaecal.com/product/strontium-boost/                              |
  |https://www.algaecal.com/product/algaecal-basic/                               |
  |https://www.algaecal.com/product/triple-omega3-fish-oil/                       |
  |https://www.algaecal.com/product/omegatest/                                    |
  |https://www.algaecal.com/sp/apsb12a/order/starter                              |
  |https://www.algaecal.com/sp/apsb12a/order/3month                               |
  |https://www.algaecal.com/sp/apsb12a/order/6month                               |



