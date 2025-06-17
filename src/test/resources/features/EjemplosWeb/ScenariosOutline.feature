@feature_scenarioOutline1
Feature: Ejercicio con Scenario Outline

  @prueba3DemoBlazeOutline @Outline_1
  Scenario Outline: Validar que al hacer clic sobre productos se muestra su pagina
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "<Producto>"
    Then valido que la ficha corresponde a "<Producto>"

    Examples:
      | Producto          |
      | Samsung galaxy s6 |
      | Nexus 6           |
      | Sony xperia z5    |


  @prueba3DemoBlazeOutline @Outline_2
 Scenario Outline: Validar que al presionar purchase en el formulario de compra se muestra el mensaje esperado "Thank you for your purchase!"
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "<Producto>"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    And realizo click sobre el boton "Place Order"
    And ingreso "<Nombre>" en el campo "Name:"
    And ingreso "<Pais>" en el campo "Country:"
    And ingreso "<Ciudad>" en el campo "City:"
    And ingreso "<NumCard>" en el campo "Credit card:"
    And ingreso "<Mes>" en el campo "Month:"
    And ingreso "<Anio>" en el campo "Year:"
    And realizo click sobre el boton "Purchase"
    Then valido que se muestra el mensaje de exito "Thank you for your purchase!"

    Examples:
      | Producto | Nombre | Pais | Ciudad | NumCard | Mes | Anio |
      | Samsung galaxy s6 | Felipe | Chile | Santiago | 123456 | 5 | 2025 |
      | Samsung galaxy s6 | juan | Bolivia | Santiago | 123456 | 5 | 2025 |
      | Samsung galaxy s6 | Felipeas | Chile | Santiago | 123456 | 5 | 2025 |
      | Samsung galaxy s6 | Felipeasd | Chile | Santiago | 123456 | 5 | 2025 |
      | Samsung galaxy s6 | Felipegf | Chile | Santiago | 123456 | 5 | 2025 |