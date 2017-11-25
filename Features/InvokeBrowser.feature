Feature: Test Functionality

  Scenario: Test Login Functionality

    Given user launches Browser
    When user launches the Url
    Then user closes the alert present
    Then user verifies "Personal" tab is present on the screen
    Then user verifies "Premier" tab is present on the screen
    Then user verifies "NRI" tab is present on the screen
    Then user verifies "SME" tab is present on the screen
    Then user verifies "Wholesale" tab is present on the screen
    Then user verifies "Agri" tab is present on the screen
    Then users hovers on "Products" and then on "Loans" and then clicks on "Car Loans"
    Then user waits maximum "10" seconds for pageload
    Then user click on the link "Car Loan EMI Calculator"