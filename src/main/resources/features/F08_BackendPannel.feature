Feature: Backgend Pannel


Scenario: “Export all Orders in csv file and display these information in console and you are able to send this file to another email id as attachment
  Given user goes to the home page "http://live.techpanda.org/index.php/backendlogin/"
  And enters the user name "user01" and password "guru99com" and clicks login
  And  user closes the pop up and hovers over the sales link then click the orders link
  When user chooses the export type as csv and then cliks export
  Then a csv file containing the orders data is downloaded to distination folder
  Then the file is logged in console and maileed to email
