Feature: Get Ticket information


Scenario: Get Ticket information by client id
    Given Ticket valid client ID
    When Getting ticket information by client ID
    Then Ticket information is returned

Scenario: Get Ticket information by invalid client id
    Given Ticket invalid client ID
    When Getting ticket information by client ID
    Then Ticket information is not returned

