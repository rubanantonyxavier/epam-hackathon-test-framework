Feature: Task1

  @Task1
  Scenario: Task1
    Given open IPL URL
    Then IPL page is opened
    When Navigate to STATS in Header
    Then STATS page is opened
    When User clicks "BATTERS" radio button in StatsType dropdown and select "ARAMCO ORANGE CAP" option
    Then "ARAMCO ORANGE CAP" is displayed in StatsType dropdown
    When User clicks "View All" button
    And User capture the Stats of Players
    And Select a player based on the respnse received from API
    Then Selected Player details page is displayed
