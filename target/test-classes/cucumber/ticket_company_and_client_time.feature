Feature: Company and client time

  Scenario: A ticket is created, and we are waiting for a response from the client.
    Given Ticket with an open status
    When Checking who is handling the ticket
    Then Ticket responsable should be the client.

  Scenario: A ticket is created, and we are actively working on it from the company's side.
    Given Ticket with an open status
    When Checking who is handling the ticket
    Then Ticket responsable should be the company.
