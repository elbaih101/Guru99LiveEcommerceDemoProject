Feature: ORders page

  Scenario: verify you can save previously placed orders as pdf
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the account link then the login link
    Then verify previously created order is in recent orders and its status is "Pending"
    Then  user clicks on My Orders Link
    And user clicks on view order link in the latest order
    When user clicks on print order and print from print dialouge
    Then the order is saved as pdf

