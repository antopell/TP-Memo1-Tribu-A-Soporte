Feature: Get Ticket information

Scenario: Get Ticket information by id
    Given Ticket valid ID
    When Getting ticket information by ticket ID
    Then Ticket information is returned 

Scenario: Get Ticket information by invalid id
    Given Ticket invalid ID
    When Getting ticket information by ticket ID
    Then Ticket information is not returned

Scenario: Get Ticket information by client id
    Given Ticket valid client ID
    When Getting ticket information by client ID
    Then Ticket information is returned

Scenario: Get Ticket information by invalid client id
    Given Ticket invalid client ID
    When Getting ticket information by client ID
    Then Ticket information is empty

Scenario: Get Ticket information by products version 
    Given Ticket valid products version
    When Getting ticket information by products version
    Then Ticket information is returned

Scenario: Get Ticket information by invalid products version
    Given Ticket invalid products version
    When Getting ticket information by products version
    Then Ticket information is empty




