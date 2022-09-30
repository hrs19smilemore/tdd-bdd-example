Feature: Calculator functions

  Scenario Outline : Adding numbers with calculator
    Given I have <opening balance>
    When I add <added>
    Then I should have <total>
    Examples:
      | opening balance | added | total |
      | 0               | 4     | 4
      | 20              | 5     | 25
      | 7               | 3     | 10

#  Scenario Outline : Subtracting numbers with calculator
#    Given I have <opening balance>
#    When I <function> <added>
#    Then I should have <total>
#    Examples:
#      | opening balance | function | added | total |
#      | 0               |          | 4     | 4
#      | 20              |          | 5     | 25
#      | 7               |          | 3     | 10
#
#  Scenario Outline : Multiplying numbers with calculator
#    Given I have <opening balance>
#    When I add <added>
#    Then I should have <total>
#    Examples:
#      | opening balance | added | total |
#      | 0               | 4     | 4
#      | 20              | 5     | 25
#      | 7               | 3     | 10
#
#  Scenario Outline : Dividing numbers with calculator
#    Given I have <opening balance>
#    When I add <added>
#    Then I should have <total>
#    Examples:
#      | opening balance | added | total |
#      | 0               | 4     | 4
#      | 20              | 5     | 25
#      | 7               | 3     | 10
