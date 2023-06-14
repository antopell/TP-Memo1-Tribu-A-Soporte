Feature: Ticket timeline
  Scenario: A new ticket is selected.
    Given Ticket is selected
    When Information is displayed
    Then Timeline is empty

  Scenario: A ticket that has been in progress for some time is selected.
    Given Ticket is selected
    When Information is displayed
    Then Timeline has ticket's history and attached files