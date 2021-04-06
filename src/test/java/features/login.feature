Feature: Login into Application
  Scenario Outline: Positive test validation
    Given initialise the browser with chrome
    And navigate to "http://www.qaclickacademy.com" site
    And click on Login link on home page to land on sign in page
    When user enters <username> and <password> and login in
    Then verify user is successfully logged in
    And close browsers
    Examples:
    |username           |password |
    |test99@gmail.com   |123456   |
    |test123@gmail.com  |456879   |


