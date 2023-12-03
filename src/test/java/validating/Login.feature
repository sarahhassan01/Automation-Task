Feature: Login

  @run
  Scenario Outline: user signin with invalid username and password
    Given user click on login button
    And user click on sign in using email
    When user insert email <email>
    And user insert password <password>
    And user click on sign in button
    Then assert You seem to have a wrong email or password message displayed
    Examples:
      | email                       | password   |
      | "Abdelrahman4040@gmail.com" | "12345678" |