Feature: Login

  @sanity
Scenario: Successful Login with Valid Credentials
  Given user Launch Chrome browser
  When User opens Url "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  When User click on Log out link
  And close browser

@regression
  Scenario Outline: Login Data Driven
    Given user Launch Chrome browser
    When User opens Url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    When User click on Log out link
    And close browser
    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |