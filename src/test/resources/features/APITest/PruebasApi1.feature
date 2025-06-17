@API_1
Feature: Clase de Api Rest - Ejemplos 1

  @testCodigos @API_1_1
  Scenario: Validar que el servicio retorna un codigo 200 en caso exitoso
    Given ejecuto el servicio "conversor" con el endpoint "conversorDeDivisas" y headers "conversorDivisas"
      | name | email | body |
      | QA Tester | qa@example.com | ¡Buena publicación! |
      | QA Tester22 | qa@example.com22 | ¡Buena publicación22! |
      | QA Tester33 | qa@example.com33 | ¡Buena publicación33! |
      | QA Tester44 | qa@example.com44 | ¡Buena publicación44! |
    Then valido que la respuesta es "201"

  @testCodigos2 @API_1_1
  Scenario: Validar que el servicio retorna un codigo 400 en caso exitoso
    Given ejecuto el servicio "conversor" con el endpoint "conversorDeDivisas2" y headers "conversorDivisas"
      | name | email | body |
      | QA Tester | qa@example.com | ¡Buena publicación! |
      | QA Tester22 | qa@example.com22 | ¡Buena publicación22! |
    Then valido que la respuesta es "404"

  @testCodigos3
  Scenario: Validar que el servicio retorna un codigo 200 en caso exitoso
    Given ejecuto el servicio "conversor" con el endpoint "conversorDeDivisas" y headers "conversorDivisas"
      | currencyFrom | currencyTo |
      | USD          | CLP        |
    Then valido que el body response tiene los campos correctos
      | Body             |
      | code             |
      | originalAmount   |
      | convertedAmount  |
      | exchangeRate     |
      | exchangeRateDate |
