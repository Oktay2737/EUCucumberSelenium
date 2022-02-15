@navigate
Feature: Navigation Menu
  Scenario: Navigation Fleet -- Vehicles
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Fleet, Vehicles
    Then the title should be Vehicles
@db
  Scenario: Navigating Marketing - Campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Marketing, Campaigns
    Then title should be Campaigns

  Scenario: Navigating Activities -- Calender Events
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Activities, Calender Events
    Then title should be Calenders