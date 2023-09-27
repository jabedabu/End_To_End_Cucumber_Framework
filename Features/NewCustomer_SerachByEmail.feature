Feature: AddCustomer_And_Search_By_Email_FirstName_LastName

  Background: Below are the Common Steps for each Scenario
    Given user Launch Chrome browser
    When User opens Url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboad

@sanity
  Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customers page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

@regression
  Scenario: Search Customer by EmailID
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customerEmail
    When Click on search button
    Then User should found Email in the Search table
    And close browser

@regression
  Scenario:  Search Customer by name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer firstName
    And Enter customer lastName
    When Click on search button
    Then User should be found the name in the Search table
    And close browser