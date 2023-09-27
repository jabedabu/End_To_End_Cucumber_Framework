Feature: Add_Customers

@sanity
Scenario: Add a new Customer
  Given user Launch Chrome browser
  When User opens Url "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then User can view Dashboad
  When User click on customers Menu
  And click on customers Menu Item
  And click on Add new button
  Then User can view Add new customers page
  When User enter customer info
  And click on save button
  Then User can view confirmation message "The new customer has been added successfully."
  And close browser

