Feature: Main Website - Functional Test For Stage
  In Order to verify Main Functionality
  As I customer of AlgaeCal
  I would like to verify website functionality


  Scenario: HCP Login Page Loads
    Given I navigate to Stage.Algaecal.com
    And I navigate to HCP login page for stage
    Then I will see all the correct page links for HCP Stage

  Scenario: Validate Links Site Wide - Staging
    Given I navigate to Stage.Algaecal.com
    Then I will navigate to each webpage and ensure the page loads and no links have a re-direct

  Scenario Outline: Validate Phone Slugs on Staging
    Given I navigate to Stage.Algaecal.com with phone slug "<phone_slug>"
    Then I will see the correct phone number for phone slug "<phone_slug>" on the homepage
    And I will see the correct phone number for phone slug "<phone_slug>" on each product detail page
    And I will see the correct phone number for phone slug "<phone_slug>" on the cart page
    And I will see the correct phone number for phone slug "<phone_slug>" on the checkout page

    Examples:
      |phone_slug|
      |adroll|
      |display|
      |gads   |
      |gads-shop-brand|
      |gads-shop-nonbrand|
      |bing-shop-brand   |
      |bing-shop-nonbrand|
      |bing              |
      |fb                |
      |pinterest         |


  Scenario Outline: Validate Phone Slugs on Staging Sales Pages
    Given I navigate to Stage.Algaecal.com with phone slug "<phone_slug>" for "/sf/bbp/"
    Then I will see the correct phone number for phone slug "<phone_slug>" on the first page I inserted the phone slug
    And I will see the correct phone number for phone slug "<phone_slug>" on each product detail page
    And I will see the correct phone number for phone slug "<phone_slug>" on the cart page
    And I will see the correct phone number for phone slug "<phone_slug>" on the checkout page

    Examples:
      |phone_slug|
     # |adroll|
    #  |display|
    #  |gads   |
    #  |gads-shop-brand|
    #  |gads-shop-nonbrand|
    #  |bing-shop-brand   |
    #  |bing-shop-nonbrand|
      |bing              |
      |fb                |

#      |salesPage                          |
#      |/sf/bbp/                           |
#      |/sf/bbp/?coupon=sb10off            |
#      |/up/bbp                            |
#      |/up/tpo                            |
#      |/sf/thank-you                      |
#      |/sf/bbp/?coupon=sb10off            |
#      |/sf/quiz/osteo-email               |
#      |/sf/quiz/osteo-email/results/      |
#      |/sf/quiz/osteo                     |
#      |/sf/quiz/osteo/results             |
#      |/sf/bbp/rlp                        |
#      |/sf/bbp/elp/calcium-rich-foods     |
#      |/sf/bbp?header=newsletter          |
#      |/sf/bbp?header=recipe-ebook        |
#      |/sf/bbp?header=testimonial         |
#      |/sf/bbp?header=reengagement        |
#      |/sf/bbp?header=long-term-nurture   |
#      |/sf/tp/?coupon=pilatestp20off      |
#      |/sf/bbp?header=build-bones         |
#      |/sf/bbp?header=osteoporosis        |
#      |/sf/bbp?header=nutrition-for-osteoporosis |
#      |/sf/bbp?header=calcium-for-osteoporosis   |
#      |/sf/bbp?header=treat-osteoporosis         |
#      |/sf/cs?header=natural-calcium             |
#      |/sf/cs?header=calcium-citrate             |
#      |/sf/cs?header=best-calcium-sources        |
#      |/sf/cs?header=best-calcium-supplement     |
#      |/sf/cs?header=calcium-supplement-side-effects|
#      |/sf/cs?header=best-absorbed-calcium          |


#Need to Update Pages To Prod URLs
  Scenario Outline: Validate Phone Slugs on Prod Sales Pages
    Given I navigate to Algaecal.com with phone slug "<phone_slug>" for "<salesPage>"
    Then I will see the correct phone number for phone slug "<phone_slug>" on the first page I inserted the phone slug
    And I will see the correct phone number for phone slug "<phone_slug>" on each product detail page
    And I will see the correct phone number for phone slug "<phone_slug>" on the cart page
    And I will see the correct phone number for phone slug "<phone_slug>" on the checkout page

    Examples:
      |salesPage                          |phone_slug|
      |/sf/bbp/                           |adroll|
  #    |/sf/bbp/?coupon=sb10off            |display|
    #  |/up/bbp                            |gads   |
    #  |/up/tpo                            |gads-shop-brand|
#      |/sf/thank-you                      |gads-shop-nonbrand|
#      |/sf/bbp/?coupon=sb10off            |bing-shop-brand   |
#      |/sf/quiz/osteo-email               |bing-shop-nonbrand|
#      |/sf/quiz/osteo-email/results/      |bing              |
#      |/sf/quiz/osteo                     |fb                |
#      |/sf/quiz/osteo/results             |  |
#      |/sf/bbp/rlp                        |  |
#      |/sf/bbp/elp/calcium-rich-foods     |  |
#      |/sf/bbp?header=newsletter          |  |
#      |/sf/bbp?header=recipe-ebook        |  |
#      |/sf/bbp?header=testimonial         |  |
#      |/sf/bbp?header=reengagement        |  |
#      |/sf/bbp?header=long-term-nurture   |  |
#      |/sf/tp/?coupon=pilatestp20off      |  |
#      |/sf/bbp?header=build-bones         |  |
#      |/sf/bbp?header=osteoporosis        |  |
#      |/sf/bbp?header=nutrition-for-osteoporosis | |
#      |/sf/bbp?header=calcium-for-osteoporosis   | |
#      |/sf/bbp?header=treat-osteoporosis         | |
#      |/sf/cs?header=natural-calcium             | |
#      |/sf/cs?header=calcium-citrate             | |
#      |/sf/cs?header=best-calcium-sources        | |
#      |/sf/cs?header=best-calcium-supplement     | |
#      |/sf/cs?header=calcium-supplement-side-effects||
#      |/sf/cs?header=best-absorbed-calcium          ||
#
