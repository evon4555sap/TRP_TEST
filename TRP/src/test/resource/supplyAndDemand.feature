Feature: Create a new plan

  Background: 
    Given I am on trp site
    And Log on with user "TRPADM" and password "Abcd1234"

  Scenario: Create a supply and demand plan
    When I click PLANS work center
    And I click Create Plan button
    And I select "Virtual KPI Plan"
    And I enter "ZTEST" in Name field
    And I select "CNTEST" in Location Filter
    And I select "BOOKINGTEST" in Resource Filter
    And I click Add button
    And I select scheduled KPI plan "JOHNNY_TEST_01"
    And I click Save button
    Then I can find plan in the list

    
    
    