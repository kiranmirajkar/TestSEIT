Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the page under test is 'https://the-internet.herokuapp.com'
    And an example Home Page step
    Then the list of examples contains all expected entries

  @TEST_TI_0002
  Scenario: Basic Auth allows validated access
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the 'Basic Auth' example is opened
    And the page under test is 'https://admin:admin@the-internet.herokuapp.com/basic_auth'
    Then Congratulations should be displayed

  @TEST_TI_0003
  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
    Given the page under test is 'https://the-internet.herokuapp.com'
    And the user clicks on the 'Sortable Data Tables' link
    Then Example 1 table displays expected results

