Feature: CRUD Operations for Crusade Forces

  Rule: Authenticated users can create crusade forces
    Example: An authenticated user tries to create a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The response is 201 Created
      And The crusade force is created
    Example: An unauthenticated user tries to create a crusade force
      Given I am not an authenticated user
      When I create a crusade force
      Then The response is 401 Forbidden
      And The crusade force is not created

  Rule: New crusade forces are assigned a unique ID
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force is assigned a unique ID

  Rule: New crusade forces must have a valid Faction
    Scenario Outline: Creating a crusade with a valid faction
      Given I am an authenticated user
      And I provide faction as <faction>
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force's faction is <faction>
      Examples:
        | faction     |
        | Imperium    |
        | Chaos       |
        | Aeldari     |
        | Tyranids    |
        | Orks        |
        | Necrons     |
        | T'au Empire |
    Scenario Outline: Creating a crusade force with an invalid faction
      Given I am an authenticated user
      And I provide faction as <faction>
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The response is 400 Bad Request
      And The response body indicates an invalid faction
      And The crusade force is not created
      Examples:
        | faction |
        | Empire  |
        | Eldar   |
        | Nids    |
        | Orcs    |
        | Tau     |
        | abc     |
        | 12345   |
        | "Chaos" |
        |         |
    Example: Creating a crusade force with no faction
      Given I am an authenticated user
      And I provide faction as null
      When I create a crusade force
      Then The response is 400 Bad Request
      And The response body indicates an invalid faction
      And The crusade force is not created

  Rule: New crusade forces must have a Player Name
    Scenario Outline: Creating a crusade force with a valid player name
      Given I am an authenticated user
      And I provide Player Name as <name>
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force's player name is <name>
      Examples:
        | name                                |
        | a lowercase string                    |
        | an uppercase string                    |
        | a mixed case string                   |
        | an alphanumeric string                 |
        | a string containing digits only       |
        | zero                                |
        | a decimal number                    |
        | literal NaN                         |
        | a regex string                      |
        | a string containing wildcard chars    |
        | a single character                  |
        | a string containing punctuation chars |
        | a string containing accented letters  |
        | a string containing non-latin chars   |
        | a SQL statement                     |
        | literal null                        |
        | literal true                        |
        | literal false                       |
        | a string containing max chars       |
        | a string containing max chars - 1   |
        | an email address                    |
        | a string containing whitespace chars |
        | a string starting with whitespace chars |
        | a string ending with whitespace chars   |
    Scenario Outline: Creating a crusade force with an invalid player name
      Given I am an authenticated user
      And I provide Player Name as <name>
      When I create a crusade force
      Then The response is 400 Bad Request
      And The response body indicates an invalid player name
      And The crusade force is not created
      Examples:
        | name |
        | an empty string |
        | a string containing only whitespace |
        | a string containing max chars + 1   |
    Example: Creating a crusade force with no player name
      Given I am an authenticated user
      And I provide player name as null
      When I create a crusade force
      Then The response is 400 Bad Request
      And The response body indicates an invalid player name
      And The crusade force is not created

  Rule: New crusade forces have participated in 0 battles
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force has a battle tally of 0

  Rule: New crusade forces have won 0 battles
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force has battles won = 0

  Rule: New crusade forces have 5 requisition points
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force has 5 requisition points

  Rule: New crusade forces have a max of 50 supply points
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force has a supply limit of 50

  Rule: New crusade forces have used 0 supply points
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force has used 0 supply points

  Rule: New crusade forces contain no crusade cards
    Example: Creating a crusade force
      Given I am an authenticated user
      And I provide all params required to create a crusade force
      When I create a crusade force
      Then The crusade force is created
      And The crusade force contains no crusade cards

  Rule: Authenticated users can retrieve crusade forces
    Example: An authenticated user tries to retrieve all crusade forces when none exist
      Given I am an authenticated user
      And No crusade forces exist
      When I retrieve all crusade forces
      Then The response is 200 OK
      And An empty array is returned

    Example: An authenticated user tries to retrieve all crusade forces when some exist
      Given I am an authenticated user
      And At least one crusade force exists
      When I retrieve all crusade forces
      Then The response is 200 OK
      And An array of all crusade forces is returned

    Example: An authenticated user tries to retrieve an existing crusade force by ID
      Given I am an authenticated user
      And I provide the ID of an existing crusade force
      When I retrieve a crusade force by ID
      Then The response is 200 OK
      And The specified crusade force is returned

    Example: An authenticated user tries to retrieve a non-existent crusade force by ID
      Given I am an authenticated user
      And I provide the ID of a crusade force that doesn't exist
      When I retrieve a crusade force by ID
      Then The response is 404 Not Found
      And Nothing is returned
    Example: An unauthenticated user tries to retrieve all crusade forces
      Given I am not an authenticated user
      When I retrieve all crusade forces
      Then The response is 401 Forbidden
      And Nothing is returned
    Example: An unauthenticated user tries to retrieve a crusade force by ID
      Given I am not an authenticated user
      When I retrieve a crusade force by ID
      Then The response is 401 Forbidden
      And Nothing is returned

  Rule: Authenticated users can delete crusade forces
    Example: An authenticated user tries to delete an existing crusade force by ID
      Given I am an authenticated user
      And I provide the ID of an existing crusade force
      When I delete a crusade force by ID
      Then The response is 204 No Data
      And The crusade force is deleted
    Example: An authenticated user tries to delete a crusade force that doesn't exist by ID
      Given I am an authenticated user
      And I provide the ID of a crusade force that doesn't exist
      When I delete a crusade force by ID
      Then The response is 404 Not Found
      And No crusade forces are deleted
    Example: An unauthenticated user tries to delete a crusade force by ID
      Given I am not an authenticated user
      When I delete a crusade force by ID
      Then The response is 401 Forbidden
      And No crusade forces are deleted