Feature: This is scenario outline feature

  Scenario Outline: Test multiple page titles
    Given user navigates to '<url>'
    Then user sees page title '<page_title>'
    Examples:
      | url                        | page_title                                    |
      | https://www.saucedemo.com/ | Swag Labs                                     |
      | https://www.google.lv/     | Google                                        |
      | https://www.lu.lv/         | Latvijas Universitāte                         |
      | https://www.delfi.lv/      | DELFI - Vadošais ziņu portāls Latvijā - DELFI |