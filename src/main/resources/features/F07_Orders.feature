Feature: ORders page

  Scenario: verify you can save previously placed orders as pdf
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the account link then the login link
    Then verify previously created order is in recent orders and its status is "Pending"
    Then  user clicks on My Orders Link
    And user clicks on view order link in the latest order
    When user clicks on print order and print from print dialouge
    Then the order is saved as pdf

Scenario: verify user can reorder product
  Given user goes to the home page "http://live.techpanda.org"
  And user clicks on the account link then the login link
  When user clicks on reorder link and change quantity and click update
  Then the grand total price is changed
  Then user enter chooses thecountry "United States" and the region "New York" and enter thr post code "542896"
  And user clisks estimate then chooses the fixed flatrate and cliks updatetotal
  Then verify that the flate rate is added to the subtotal in the grand total
  When user clicks on procede to checkout he is directed to checkoutpage
  And  user cliks on containue button and containue button
  Then  user chooses  payment method by check and clicks containue
  And user place orderbutton
  Then success message is shown containing "Your order has been received"
 Then note the order number and verify its generated
