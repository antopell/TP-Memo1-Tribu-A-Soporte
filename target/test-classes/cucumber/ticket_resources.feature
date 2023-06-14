Feature: Ticket's resources
  Scenario: The ticket has a resource assigned.
    Given Ticket has a resource assigned
    When Ticket is selected
    Then Assigned resource is displayed

  Scenario: The ticket does not have a resource assigned.
    Given Ticket does not have any assigned resources
    When Tickets is selected
    Then No assigned resource is displayed

