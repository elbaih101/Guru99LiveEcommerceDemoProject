Feature: Mobile List

  Scenario: Verify  items in mobile list page can be sorted by name
    Given user goes to the home page "http://live.techpanda.org"
    Then verify the title of the page is "Home page"
    And  text "THIS IS DEMO SITE" is shown on home page
    When user clicks on the Mobile menu
    Then user is directed to the mobile list page and verify the title is "Mobile"
    When user selects sort by "Name"
    Then all 3 elemnts are sorted by name