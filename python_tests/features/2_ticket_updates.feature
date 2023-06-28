Feature: Update Ticket

  Scenario: Update ticket severity successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket severity
    Then Ticket severity should be updated successfully

  Scenario: Update ticket priority successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket priority
    Then Ticket priority should be updated successfully

  Scenario: Update ticket title successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket title
    Then Ticket title should be updated successfully
  
  Scenario: Update ticket description successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket description
    Then Ticket description should be updated successfully

  Scenario: Update ticket client successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket client
    Then Ticket client should be updated successfully
  
  Scenario: Update ticket product version successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket product version
    Then Ticket product version should be updated successfully

  Scenario: Update ticket state successfully
    Given Ticket with state PENDIENTE or EMPEZADO
    When Updating the ticket state
    Then Ticket state should be updated successfully

  Scenario: Fail to update ticket
    Given Invalid ticket ID
    When Updating the ticket state
    Then Ticket should fail with a "Ticket not found" error
  
  Scenario: Can't update a closed ticket
    Given Ticket with state RESUELTO
    When Updating the ticket state
    Then Update should fail with a "Closed tickets cant be updated" message
