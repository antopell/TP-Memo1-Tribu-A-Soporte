Feature: Ticket evolution
  Scenario: Succesfully getting a resolved ticket statistics
    Given Ticket with a closed status
    When Trying to get ticket statistics
    Then Resolved Ticket is returned
  """
  ^^Evolution of priorities, severities for a particular ticket
  """
  Scenario: Succesfully get average resolution time
    Given A list of Tickets with a closed status
    When Trying to get the average resolution time
    Then Average resolution time is returned

  Scenario: Can not get average resolution time because there is no resolved tickets
    Given There is no Tickets with a closed status
    When Trying to get the average resolution time
    Then 0 is returned
"""
  Scenario: Accessing the ticket statistics section and there are resolved tickets.
    Given Ticket with a closed status
    When Trying to get ticket statistics
    Then Average resolution time of the resolved tickets should be displayed

  Scenario: Clicking on a specific ticket that has changed in priority and severity.
    Given Ticket has changed in priority and severity
    When Ticket is selected
    Then Evolution of priorities and severities is displayed

  Scenario: Clicking on a specific ticket that has changed in severity.
    Given Ticket has changed in severity
    When Ticket is selected
    Then Evolution of severities is displayed

  Scenario: Clicking on a specific ticket that has changed in priority.
    Given Ticket has changed in priority
    When Ticket is selected
    Then Evolution of priorities is displayed
"""
