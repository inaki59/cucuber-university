@saturday
Feature: Is it Saturday yet?
  Everybody wants to know when it´s Saturday

  Scenario Outline: Checking if today is day correct
    Given today is "<today>"
    When compare days
    Then I should be told realdays "<dayReal>"

    Examples:
      | today     | dayReal   |
      | Tuesday   | Tuesday   |
      | Wednesday | Wednesday |
      | Friday | Friday |
