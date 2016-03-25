Feature: Test banner tabs on the main page

  Scenario: Click on all banner tabs and check products on tabs
    Given New browser session started and home page is opened
    When User clicks on banner tabs one by one
    Then All data of products should correspond next:
      | ProductsName |  Price   | Currency | Detail    |Picture|
      | ^.*\w$       |  ^.*\d$  |  грн.    | Подробнее |  true |


