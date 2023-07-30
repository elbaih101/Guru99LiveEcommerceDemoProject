Feature: Verify cost attribute
  Scenario: Verify cost on list page equals cost in details page
    Given user goes to the home page "http://live.techpanda.org"
    When user clicks on the Mobile menu
    Then get the cost of the "Sony Xperia" mobilephone
    When  user clicks on the "Sony Xperia" mobilephone
    Then compare the price from the detail page with the list page