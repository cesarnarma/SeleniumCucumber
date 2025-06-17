@feature_dataTables
Feature: Ejercicio con DataTables

  @ejercicio_dataTable1
  Scenario: verificar funcionamiento de dataTable con una columna
    Given le estoy pasando al datablable una columna
      | Lenguajes  |
      | Java       |
      | C#         |
      | Javascript |
      | Python     |

  @ejercicio_dataTable2
  Scenario: verificar funcionamiento de dataTable con una columna
    Given le estoy pasando al datablable dos columnas
      | Paises    | Ciudades |
      | Chile     | Santiago |
      | Argentina | Cordoba  |
      | Venezuela | Caracas  |
      | Peru      | Lima     |

  @ejercicio_dataTable3
  Scenario Outline: Validar que al presionar purchase en el formulario de compra se muestra el mensaje esperado “Thank you for your purchase!”
    Given estoy en la web de "https://www.demoblaze.com/"
    When realizo click sobre el producto "<Producto>"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    And realizo click sobre el boton "Place Order"
    And ingreso los datos del cliente en el formulario
      | Dato      | Campo        |
      | <Nombre>  | Name:        |
      | <Pais>    | Country:     |
      | <Ciudad>  | City:        |
      | <NumCard> | Credit card: |
      | <Mes>     | Month:       |
      | <Anio>    | Year:        |
    And realizo click sobre el boton "Purchase"
    Then valido que se muestra el mensaje de exito "Thank you for your purchase!"

    Examples:
      | Producto          | Nombre | Pais    | Ciudad   | NumCard       | Mes | Anio |
      | Samsung galaxy s6 | Felipe | Chile   | Santiago | 1111 2222 333 | 05  | 2025 |
      | Iphone 6 32gb     | Juana  | Bolivia | Paz      | 1444 5555 333 | 12  | 2029 |
