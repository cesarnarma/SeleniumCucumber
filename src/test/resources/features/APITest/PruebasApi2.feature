@API_2
Feature: Clase de Api Rest - Ejemplos 2

  @testAPIBodyRequest1 @API_2_1
  Scenario: Validar que el servicio de conversion retorna los campos correctos en su body request
    Given ejecuto el servicio "conversor" con el endpoint "conversorDeDivisas" y headers "conversorDivisas"
      | name | email | body |
      | QA Tester | qa@example.com | ¡Buena publicación! |
      | QA Tester22 | qa@example.com22 | ¡Buena publicación22! |
    Then valido que el body response tiene los campos correctos
      | BodyResponse     |
      | name |
      | email|
      | body |
      | postId |
      | id |

  @testAPIBodyRequest1 @API_2_2
  Scenario Outline: Validar que el servicio de conversion retorna los campos correctos en su body request
    Given ejecuto el servicio "conversor" con el endpoint "conversorDeDivisas" y headers "conversorDivisas"
      | name | email | body |
      | QA Tester | qa@example.com | ¡Buena publicación! |
      | QA Tester22 | qa@example.com22 | ¡Buena publicación22! |
    Then valido que el body response indica que para una conversion de <qa@example.com>
      | BodyResponse     |
      | name |
      | email|
      | body |
      | postId |
      | id |
    Examples:
      |  |
