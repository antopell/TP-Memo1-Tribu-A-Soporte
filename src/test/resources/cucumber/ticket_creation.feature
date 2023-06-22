Feature: Ticket creation

  Scenario: Given that I know the client, their product, and its version, I create the corresponding ticket.
    Given Product, version, and client
    When Trying to create the ticket
    Then Ticket is created #(and returned)


  Scenario: Given that I don't know the client, I am unable to create the ticket.
    Given Product and version
    When Trying to create the ticket
    Then the ticket is not created
    And Client is requested.

  Scenario: Given that I don't know the version of the product, I am unable to create the ticket.
    Given Product and client
    When Trying to create the ticket
    Then Ticket is not created
    And Version is requested

  Scenario: Given that I don't know the client's product, I am unable to create the ticket.
    Given Client and version
    When Trying to create the ticket
    Then Ticket is not created
    And Product is requested