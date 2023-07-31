Feature: Verify Shoping Cart

  Scenario: Verify you cant more product in the cart thats available in the store
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the Mobile menu
    When user click on the add to cart button for the sony xperia phone
    And set the quantity to "1000" and click the update button
    Then an error message should appear
    When clicking the empty cart
    Then the cart should be empty