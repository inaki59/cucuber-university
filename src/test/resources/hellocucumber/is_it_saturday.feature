@pruebareal
Feature: Is it Saturday yet?
  Everybody wants to know when it´s Saturday

  Scenario Outline: "<today>" is "<dayReal>"
    Given  today is "<today>"
    When compare days
    Then I should be told realdays "<same>"
    Examples:
      | today | dayReal | same|
      |Tuesday| Tuesday |true|
      |wednesday| Friday    |false|

