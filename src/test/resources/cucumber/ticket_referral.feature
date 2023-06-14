Feature: Ticket referral
  Scenario: Since the ticket requires a task to be resolved, it is created in the corresponding project.
    Given Ticket exist
    When Create a new task
    Then Task is created

  Scenario: As I know which resource to assign to the ticket, the assignment is done correctly.
    Given Ticket require an assigned resource
    When Assigning an available resource
    Then Ticket is assigned to that resource

  Scenario: If the resource to assign is not available, the assignment cannot be made.
    Given Ticket require an assigned resource
    When Assigning an unavailable resource
    Then Ticket is not assigned to resource
