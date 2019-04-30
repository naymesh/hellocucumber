Feature: Search
  Everybody needs to search something everyday

Scenario: Decide Search Engine
    Given I have a favourite search engine
    When I want to search something
    Then My favourite search engine should load
