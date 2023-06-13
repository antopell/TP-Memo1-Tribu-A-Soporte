Feature: Ticket creation

  Scenario: Successfully create a ticket with all the information
    Given Product with version, and client
    When Trying to create the ticket
    Then The ticket is created with a version and a client.

