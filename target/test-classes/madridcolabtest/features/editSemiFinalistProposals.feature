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
# encoding: utf-8
Feature: Selecci�n de propuestas
  Como equipo del concurso quiero poder gestionar las decisiones de la propuesta para poder avanzar la propuesta a siguientes fases del concurso.

Background: contest in proposal revision phase
		Given a proposal which a judge decide that can be advance
    When the fellow go to advance proposals selection section
    And advance the proposal
    And the proposal is visible in the Proposal Revision Phase


  @EditSemiFinalistProposal
  Scenario: Creaci�n propuestas deshabilitado en la fase Revision de propuestas
    Given a contest which is in proposal revision phase
    When a member access to the contest
    Then the button to create new proposals is disabled

  @EditSemiFinalistProposal
  Scenario: Propuesta que ha llegado a la fase Revision de propuestas como semifinalista puede ser editada
    Given a semi-finalist proposal in proposal revision phase
    When the author enter in the proposal page
    Then the author can edit the proposal
    
