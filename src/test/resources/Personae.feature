Feature: Standard definitions

#  Scenario: Occidental sub-network (very unsatisfying)
#    Given the occidental sub-network
#    Then Paris should be linked to Milan
#    Then Paris should be linked to Essen
#    Then Paris should be linked to London
#    Then Paris should be linked to Madrid
#    Then Paris should be linked to Algiers
#    Then Milan should be linked to Essen
#    Then Essen should be linked to London
#    Then London should be linked to NY
#    Then NY should be linked to Madrid
#    Then Madrid should be linked to Algiers

#  Scenario Outline: Occidental sub-network for <cityA>/<cityB> link (mildly unsatisfying)
#    Given the occidental sub-network
#    Then <cityA> should be linked to <cityB>
#    Examples:
#      | cityA  | cityB   |
#      | Paris  | Milan   |
#      | Paris  | Essen   |
#      | Paris  | London  |
#      | Paris  | Madrid  |
#      | Paris  | Algiers |
#      | Milan  | Essen   |
#      | Essen  | London  |
#      | London | NY      |
#      | NY     | Madrid  |
#      | Madrid | Algiers |

  Scenario: Occidental sub-network (quite satisfying)
    Given the occidental sub-network
    Then the network should be:
      |         | NY | Algiers | Madrid | London | Essen | Milan | Paris |
      | Paris   |    | x       | x      | x      | x     | x     |       |
      | Milan   |    |         |        |        | x     |       |       |
      | Essen   |    |         |        | x      |       |       |       |
      | London  | x  |         |        |        |       |       |       |
      | Madrid  | x  |         |        |        |       |       |       |
      | Algiers |    |         |        |        |       |       |       |
      | NY      |    |         |        |        |       |       |       |
