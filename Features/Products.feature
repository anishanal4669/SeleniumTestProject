Feature: Test Functionality

  @ignore
  Scenario: Test Login Functionality

    Given user launches Browser
    When user launches the Url
    Then user closes the alert present
    Then users hovers on "Products" and then on "Investments" and then clicks on "InvestTrack"
    Then user clicks on the element "Expand All"
    Then user scrolls the screen to "InvestTrack Model Portfolio here"
    Then user clicks on the button "InvestTrack Model Portfolio here"
    Then user capture the table headers

  @ignore1
  Scenario: Test Premier Page

    Given user launches Browser
    When user launches the Url
    Then user closes the alert present
    Then user clicks on "Premier" tab
    Then user closes the alert present
    Then users hovers on "Products" and then on "Investments" and then clicks on "InvestTrack"
    Then user clicks on the element "Expand All"
    Then user scrolls the screen to "InvestTrack Model Portfolio here"
    Then user clicks on the button "InvestTrack Model Portfolio here"
    Then user capture the table headers