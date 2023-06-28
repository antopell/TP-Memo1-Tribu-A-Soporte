Feature: Delete ticket

Scenario: Delete an existing ticket
    Given Ticket with state PENDIENTE or EMPEZADO
    When Delete the ticket
    Then Ticket is deleted

Scenario: Delete an existing ticket
    Given Ticket with state RESUELTO
    When Delete the ticket
    Then Ticket is not deleted

Scenario: Can't delete a ticket that doesn't exist
    Given Invalid ticket id
    When Delete the ticket
    Then Ticket is not deleted
