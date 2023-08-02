Feature: verifying wish list
  Scenario:verifying u can send wish list through email
    Given user goes to the home page "http://live.techpanda.org"
    And user clicks on the account link then the register link
    Then user is directed to register page and fills the requierd data firstname "zoba" last name "zoba" email "zobazoba@zoba.com" password "zobazoba"
    And clicks on register button
    Then a message indicating succesful registration is shown containing "Thank you for registering with Main Website Store"
    And user clicks on the Tv link to get directed to tv menu
    Then user adds product "LGLCD" to wish list
    When user clicks share list user is directed to sharing page message containing "LG LCD has been added to your wishlist" should appear
    Then user enters email addres "zobyzoby@zoby.com" and message "hola zoby"
    Then confirmation message appears containing "Your Wishlist has been shared"