$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("results.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Sistema de votaciones",
  "description": "",
  "id": "sistema-de-votaciones",
  "keyword": "Feature"
});
formatter.background({
  "line": 22,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 23,
  "name": "a proposal which a judge decide that can be advance",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "the fellow go to advance proposals selection section",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "advance the proposal",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "the proposal is visible in the Proposal Revision Phase",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "wait until phase change to finalist selection phase",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "a proposal in a contest in phase Finalist selection",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "a fellow decide advance the proposal",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "select the judge",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "the judge decide that can be advance",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "the fellow go to advance proposals selection section",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "advance the proposal",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "the proposal is visible in the voting Phase",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.a_proposal_which_a_judge_decide_that_can_be_advance()"
});
formatter.result({
  "duration": 248019935426,
  "error_message": "java.lang.NullPointerException\r\n\tat madridcolabtest.steps.SemiFinalistSelection.a_proposal_which_a_judge_decide_that_can_be_advance(SemiFinalistSelection.java:221)\r\n\tat ✽.Given a proposal which a judge decide that can be advance(results.feature:23)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SemiFinalistSelection.the_fellow_go_to_advance_proposals_selection_section()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.advance_the_proposal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.the_proposal_is_visible_in_the_Proposal_Revision_Phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FinalistSelection.waitUntilPhaseChange()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FinalistSelection.a_proposal_in_a_contest_in_phase_Finalist_selection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.a_fellow_decide_advance_the_proposal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.select_the_judge()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FinalistSelection.a_finalist_proposal_which_a_judge_decide_that_can_be_advance()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.the_fellow_go_to_advance_proposals_selection_section()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SemiFinalistSelection.advance_the_proposal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FinalistSelection.the_proposal_is_visible_in_the_voting_Phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 49,
  "name": "Retirar voto",
  "description": "",
  "id": "sistema-de-votaciones;retirar-voto",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 48,
      "name": "@votingSystem"
    }
  ]
});
formatter.step({
  "line": 50,
  "name": "a \"member\" into the proposal which can be vote",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "vote for the proposal",
  "keyword": "When "
});
formatter.step({
  "line": 53,
  "name": "close voting message",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "click on remove vote",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "the button change to vote again",
  "keyword": "Then "
});
formatter.step({
  "line": 56,
  "name": "the count decreased in 1",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "member",
      "offset": 3
    }
  ],
  "location": "VotingSystem.goIntoProposalInVotingPhase(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "20190108215141311",
      "offset": 45
    },
    {
      "val": "Password123",
      "offset": 81
    }
  ],
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VotingSystem.voteProposal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VotingSystem.closeVotingMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VotingSystem.removeVote()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VotingSystem.checkButtonChangeToVote()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VotingSystem.checkDecreaseVotesCount()"
});
formatter.result({
  "status": "skipped"
});
});