Feature: compare

  Scenario: verifyin the ability to compare two products
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the Mobile menu
    When  user clicks on add to compare button for two mobile phones "Samsung Galaxy" and "Sony Xperia"
    And user clicks on the compare button on the compare menue
    Then a pop up window pops containing the two products
    Then user closes the pop up window