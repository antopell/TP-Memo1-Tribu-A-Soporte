Feature: Ticket priority and severity.
  Scenario: A ticket has been created for a high-priority client
    Given Client is high-priority
    When Ticket is created
    Then Ticket priority is high


  Scenario: A ticket has been created for a lower-priority client
    Given Client is lower-priority
    When Ticket is created
    Then Ticket priority is low

  Scenario: A ticket is created for a problem that completely hinders the functionality of the client's product.
    Given Problem hinders the functionality of the client's product.
    When Ticket is created
    Then Ticket severity is S4

  Scenario: A ticket is created for a problem that does not affect the functionality of the client's product.
    Given Problem that does not affect the functionality of the client's product
    When Ticket is created
    Then Ticket severity is S1

  Scenario: Succesfully change ticket severity to S4
    Given Ticket with an open status
    When Trying to change the ticket severity to S4
    Then Ticket severity should be S4

  Scenario: Succesfully change ticket severity to S3
    Given Ticket with an open status
    When Trying to change the ticket severity to S3
    Then Ticket severity should be S3

  Scenario: Succesfully change ticket severity to S2
    Given Ticket with an open status
    When Trying to change the ticket severity to S2
    Then Ticket severity should be S2

  Scenario: Succesfully change ticket severity to S1
    Given Ticket with an open status
    When Trying to change the ticket severity to S1
    Then Ticket severity should be S1

  Scenario: Cannot change ticket severity to S4 due to the ticket being closed
    Given Ticket with a closed status with S3 severity
    When Trying to change the ticket severity to S4
    Then Ticket severity should remain S3

