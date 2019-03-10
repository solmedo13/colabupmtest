#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login
  Como usuario quiero poder acceder a la plataforma de colaboraci�n con mi usuario y contrase�a.

  @login
  Scenario: Usuario y password correctos
    Given a "user" in the platform main page
    When click on enter button
    And insert a valid credentials
    Then the user sign in

  @login
  Scenario: Datos de acceso incorrectos
    Given a "user" in the platform main page
    When click on enter button
    And insert a invalid credentials
    Then an error is shown

  @login
  Scenario: Datos de acceso incorrectos
    Given a "user" in the platform main page
    When click on enter button
    And insert a invalid credentials
    Then the message "Error de autenticaci�n, comprueba tu nombre de usuario y contrase�a." is shown

  @login
  Scenario: Cerrar sesion
    Given a "user" in the platform main page
    And logged in the platform with his username as "solmedo" and password as "odemlo13"
    When click on close session
    Then the session closed rightly
