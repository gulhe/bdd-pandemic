Feature: Outbreak counter

  Scenario: Single outbreak
    Given Paris infection level is 3
    And outbreak counter is 0
    When Paris gets infected
    Then the outbreak counter should be 1

  Scenario: Final outbreak of Armageddon
    Given Paris infection level is 3
    And outbreak counter is 7
    When Paris gets infected
    Then the outbreak counter should be 8
    And the game should be lost