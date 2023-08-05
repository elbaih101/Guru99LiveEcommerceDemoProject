Feature: verifying Shoping Cart
  Scenario: verify user can puchase a product using registered email
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the account link then the login link
    And user clicks on my wish list link
    When user clisks on add to cart in wish list page he is directed to shoping cart page
    Then user enter chooses thecountry "United States" and the region "New York" and enter thr post code "542896"
    And user clisks estimate then chooses the fixed flatrate and cliks updatetotal
    Then verify that the flate rate is added to the subtotal in the grand total
    When user clicks on procede to checkout he is directed to checkoutpage
    And  user cliks on containue button and containue button
    Then  user chooses  payment method by check and clicks containue
    And user place orderbutton
    Then success message is shown containing "Your order has been received"
