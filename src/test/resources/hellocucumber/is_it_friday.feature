Feature: Is it Friday yet?
  Everybody wants to know when it is Friday

  Scenario: Sunday is not Friday
    Given today is Sunday
    When I ask whether its Friday yet
    Then I should be told "Nope"