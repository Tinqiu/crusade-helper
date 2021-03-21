Feature: CRUD Operations for Crusades

  Rule: Authenticated users can create crusades

    Example: An authenticated user tries to create a crusade
      Given I am an authenticated user
      And I provide all the required values to create a crusade
      When I create a crusade
      Then The response is 201 Created
      And The crusade is created
      And The created crusade is returned

    Example: An unauthenticated user tries to create a crusade
      Given I am not an authenticated user
      When I create a crusade
      Then The response is 401 Forbidden
      And The crusade is not created
      And Nothing is returned

  Rule: Crusades are created with a unique ID

    Example: A crusade is created
      Given I am an authenticated user
      And I provide all the required values
      When I create a crusade
      Then The crusade is assigned a unique ID

  Rule: Crusades are created with no crusade forces

    Example: A crusade force is created
      Given I am an authenticated user
      And I provide all the required values to create a crusade
      When I create a crusade
      Then The crusade does not contain any crusade forces

  Rule: Authenticated users can retrieve crusades

    Example: An authenticated user tries to retrieve all crusades
      Given I am an authenticated user
      When I retrieve all crusades
      Then The response is 200 OK
      And All crusades are returned

    Example: An authenticated user tries to retrieve a specific, existing crusade
      Given I am an authenticated user
      And I provide the ID of an existing crusade
      When I retrieve a crusade by ID
      Then The response is 200 OK
      And TThe specified crusade is returned.

    Example: An authenticated user tries to retrieve a specific crusade that doesn't exist
      Given I am an authenticated user
      And I provide the ID of a crusade that doesn't exist
      When I retrieve a crusade by ID
      Then The response is 404 Not Found
      And Nothing is returned

    Example: An unauthenticated user tries to retrieve all crusades
      Given I am not an authenticated user
      When I retrieve all crusades
      Then The response is 401 Forbidden
      And Nothing is returned

    Example: An unauthenticated user tries to retrieve a specific crusade
      Given I am not an authenticated user
      When I retrieve a crusade by ID
      Then The response is 401 Forbidden
      And Nothing is returned

  Rule: Authenticated users can delete crusades

    Example: An authenticated user tries to delete an existing crusade.
      Given I am an authenticated user
      And I provide the ID of an existing crusade
      When I delete a crusade by ID
      Then The response is 204 No Data
      And The crusade is deleted

    Example: An authenticated user tries to delete a crusade that doesn't exist.
      Given I am an authenticated user
      And I provide the ID of a crusade that doesn't exist
      When I delete a crusade by ID
      Then The response is 404 Not Found
      And Nothing is returned

    Example: An unauthenticated user tries to delete a crusade
      Given I am not an authenticated user
      When I delete a crusade by ID
      Then The response is 401 Forbidden
      And Nothing is returned
      And No crusades are deleted
