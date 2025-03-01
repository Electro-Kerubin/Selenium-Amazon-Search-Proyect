@Login
Feature: Login

    Scenario: Unsuccessful login with invalid username
        Given the user is on the login page
        When the user enters invalid username
        Then an email error message should be displayed

    Scenario: Unsuccessful login with valid username and invalid password
        Given the user is on the login page
        When the user enters valid username and invalid password
        And the user clicks on the login button
        Then an password error message should be displayed

    Scenario: Unsuccessful login with empty credentials
        Given the user is on the login page
        When the user leaves the username and password fields empty
        Then an error message should be displayed

    Scenario: Successful login with valid credentials
        Given the user is on the login page
        When the user enters valid username and password
        And the user clicks on the login button
        Then the user should be redirected to the homepage