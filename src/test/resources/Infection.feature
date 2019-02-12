Feature: Infection

  Scenario: First infection
    Given Paris is healthy
    When Paris gets infected
    Then infection level of Paris should be 1

  Scenario Outline: Infection number <current-infection-level>
    Given Paris infection level is <previous-infection-level>
    When Paris gets infected
    Then infection level of Paris should be <current-infection-level>
    Examples:
      | previous-infection-level | current-infection-level |
      | 1                        | 2                       |
      | 2                        | 3                       |

  Scenario: Fourth infection
    Given Paris infection level is 3
    When Paris gets infected
    Then infection level of Paris should remain at 3
