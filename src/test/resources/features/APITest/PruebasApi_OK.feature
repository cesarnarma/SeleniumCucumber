@featureApi1 @API_REQRES
Feature: Clase de Api Rest - Ejemplos API OPERATIVA AL 22-10-2024

  @test_registro_user
  Scenario: Validar que el servicio retorna un codigo 201 en caso exitoso
    Given ejecuto el servicio "registroUser" con el endpoint "registroUsuario" y headers "registroUsers_head"
      | name    | job  |
      | Juanito | Tester |
    Then valido que la respuesta es "201"

  @test_registro_user_bad
  Scenario: Validar que el servicio retorna un codigo 404 en caso exitoso
    Given ejecuto el servicio "registroUser" con el endpoint "registroUsuario_bad" y headers "registroUsers_head"
      | name   | job |
      | Pepito | CEO   |
    Then valido que la respuesta es "404"

  @test_registro_user_fields
  Scenario: Validar que el servicio retorna un codigo 200 en caso exitoso
    Given ejecuto el servicio "registroUser" con el endpoint "registroUsuario" y headers "registroUsers_head"
      | name    | job  |
      | Juanito | Tester |
    Then valido que el body response tiene los campos correctos
      | Body      |
      | name      |
      | job       |
      | id        |
      | createdAt |
