@featureBBDD
Feature: Pruebas con BBDD

  @test1_BBDD
  Scenario Outline: Validar que para un ID el nombre y apellido materno es correcto
    Given realizo la consulta para ID <id>
    Then valido que el nombre sea "<nombre>" y el apellido materno es "<apellido_materno>"

    Examples:
      | id | nombre  | apellido_materno |
      | 1  | juan    | farias           |
      | 2  | pedro   | arce             |
      | 3  | Cesar   | Martinez         |

  @test2_BBDD
  Scenario Outline: Validar que para los usuarios su tipo es el esperado
    Given realizo la consulta para verificar el tipo de usuario para ID <id>
    Then valido el tipo de usuario pars el ID es "<tipo>"

    Examples:
      | id | tipo  |
      | 1  | user  |
      | 2  | user  |
      | 3  | Admin |
      | 4  | user  |