Feature: CucumberSteps

  Scenario: This test should pass

    Given I want the test to pass

    Then The test will pass


  Scenario: This test shouldn't pass

    Given I don't want the test to pass

    Then The test will fail


  Scenario: This test should break

    Given I want the test to break

    Then The test will break


  Scenario: This tests data tables

    Given I have this list
      | object1 | 3      |
      | object2 | 4      |
      | object3 | 5      |

    When I add them

    Then I should get 12
