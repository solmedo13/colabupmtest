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
Feature: Tema personalizado corporacion
  Como usuario quiero poder ver la aplicación con el tema y los estilos que se ajustan a la organización.

  #When the Given is common, we can write it in a Background
  @Theme
  Scenario: Nombre Organización
    Given a "user" in the platform main page
    When check the platform name
    Then the name is "Colab UPM"

  @Theme
  Scenario: Logo organización
   Given a "user" in the platform main page
    When check the path of the logo image
    Then is the path of the theme "MADRID_COLAB"

  @Theme
  Scenario: Color primario corporativo del que nacen el resto de colores
    Given a "user" in the platform main page
    When check the primary color
    Then is "#0072ce"

  @Theme
  Scenario: Hoja de estilo personalizada
    Given a "user" in the platform main page
    When check the stylesheets
    Then are the stylesheets related to the theme "MADRID_COLAB"

  @Theme
  Scenario: Lenguaje castellano por defecto
    Given a "user" in the platform main page
    When check the language by default
    Then is spanish

  @Theme
  Scenario: change language to english
   Given a "user" in the platform main page
    When change the language to english
    And check the language
    Then the language change to english rightly

  @Theme
  Scenario: change language to spanish
    Given a "user" in the platform main page
    When change the language to spanish
    And check the language
    Then the language change to spanish rightly
