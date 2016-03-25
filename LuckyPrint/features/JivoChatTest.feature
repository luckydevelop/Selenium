Feature: Test Jivo Chat

  Background:
    Given User starts new browser session

  Scenario: Jivochat window automatically opening functionality
    Given User opens home page
    And JivoChat window is present and reduced
    When JivoChat is opened automatically with certain delay
    Then JivoChat window is opened automatically and contains the following:
      | Textarea                          | HelloMessage                   | Operator | Consultant  |
      | Введите сообщение и нажмите Enter | Здравствуйте, чем могу помочь? | оператор | Консультант |
    And User closes JivoChat
    And JivoChat window is present and reduced

  Scenario: Jivochat window manual opening functionality
    Given User opens home page
    And JivoChat window is present and reduced
    When User opens JivoChat
    Then JivoChat window is opened manually and contains the following:
      | Textarea                          | Operator | Operator2                |
      | Введите сообщение и нажмите Enter | оператор | Напишите Ваше сообщение! |
    And User closes JivoChat
    And JivoChat window is present and reduced

  Scenario Outline: Jivochat presence on all pages
    When User loads "<page>"
    Then JivoChat window is present and reduced

    Examples:
      | page                                                                               |
      | http://lucky-print.com.ua/snpch/                                                   |
      | http://lucky-print.com.ua/printer/                                                 |
#      | http://lucky-print.com.ua/mfu-epson/wf-7610dwf.html                                |
#      | http://lucky-print.com.ua/ultrakhromnyye-chernila/dlya-epson-r2000-8-po-100ml.html |
#      | http://lucky-print.com.ua/kontakty-kiev.html                                       |
#      | http://lucky-print.com.ua/dostavka-i-oplata.html                                   |

  Scenario: Jivochat presence on basket page
    Given User opens home page
    And User selects product from promo banner
    And User adds product to basket
    When User selects basket
    Then JivoChat window is present and reduced



