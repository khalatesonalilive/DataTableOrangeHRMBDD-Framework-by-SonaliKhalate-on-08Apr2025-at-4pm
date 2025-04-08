Feature: Test OrangeHRM Application

  Scenario: Test Login Page Functionality
    Given user is on Login Page
    When user enter valid credentials
      | Admin | admin123 |
    And user click on login button

  Scenario: Test Home Page Functionality
    When user is on home page and validate the home page title
      | OrangeHRM |
    And user validate the home page url
    And user validate the home page logo
      | true |

  Scenario: Test PIM Page Functionality
    When user click on pim page link
    And user validate the user is on pim page using the url
      | pim |
    And user click add employee and enter firstname, lastname and click on save button
      | Shivanya | Bhosale  |
      | Siya     | Ram      |
      | radha    | shyam    |
      | vitthal  | RakhuMai |
    And user capture the employee id number and user click on employee list
    And user enter employee id in employee id textbox and click on search button
    And user select the search employee and click on delete
    Then validate the employee is deleted or not

  Scenario: Test Logout Functionality
    When user click on profile and click on logout button
