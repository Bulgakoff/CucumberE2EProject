Feature: Login into Application
  Scenario Outline: Positive test valiation login
    Given Initialize test with chrome
    And  Navigate to "https://qaclickacademy.com" site
    And Click on Login link in home page to land on Secure sign in page
    When User enters the <username> & <password> and logs in
    Then Verify that user is successfully logged in
    And close browser



Examples:
  |username |password |
  |test00@qmail.com |789456 |
  |test11@qmail.com |qwe123 |
  |test1451@qmail.com |qwe1343 |