@featureApi3 @API_REQRES
Feature: Clase de Api Rest - Ejemplos API OPERATIVA AL 22-10-2024 parte 2

  @test_login_user
  Scenario: Validar que el servicio retorna un codigo 200 en caso exitoso al logearnos
    Given ejecuto el servicio "loginUser" con el endpoint "loginUser" y headers "registroUsers_head"
      | email              | password |
      | eve.holt@reqres.in | 1234     |
    Then valido que la respuesta es "200"

  @test_login_user_bad
  Scenario: Validar que el servicio retorna un codigo 400 en caso de password incorrecta
    Given ejecuto el servicio "loginUser" con el endpoint "loginUser" y headers "registroUsers_head"
      | email              | password |
      | eve.holt@reqres.in |          |
    Then valido que la respuesta es "400"

  @test_login_user_bad_msg
  Scenario: Validar que el servicio retorna el mensaje Missing password en caso de error
    Given ejecuto el servicio "loginUser" con el endpoint "loginUser" y headers "registroUsers_head"
      | email              | password |
      | eve.holt@reqres.in |          |
    Then valido que la respuesta incluye el mensaje "Missing password"
