Feature: Client product information on the ticket.

  Scenario: The client has a modified version of the product.
    Given Client has a modified version of the product
    When Checking the ticket modifications
    Then Ticket modifications should have the modification.

  Scenario: The client has a license of the product.
    Given Client has a license of the product
    When Checking the ticket version
    Then Ticket version should have the client's version.
"""
  Scenario: The user wants to see information of the ticket.
    Given 
    When Checking the ticket
    Then Ticket is returned.
"""