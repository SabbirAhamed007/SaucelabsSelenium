Feature: Test BDDL Reaz Bag flat feature

  @tag2
  Scenario: Test BDDL Reaz Bag apartment scenario
    Given I open BDDL Reaz Bag apartment page
    And change the picture for BDDL Reaz Bag apartment
    When I verify text for BDDL Reaz Bag apartment
    And I verify monthly mortgage payment for BDDL Reaz Bag apartment
    Then close the browser for BDDL Reaz Bag apartment
