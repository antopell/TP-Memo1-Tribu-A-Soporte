Feature: Ticket resolution time

  Scenario: A ticket is being displayed on the screen, and the time has not expired.
    Given Ticket has been created
    When Ticket is viewed on the screen
    Then Remaining time to resolve the issue is displayed

  Scenario: A ticket is being displayed on the screen, and the time has expired.
    Given Ticket has been created
    When Ticket is viewed on the screen
    Then Remaining time is displayed in red color
    And Time since the ticket expired