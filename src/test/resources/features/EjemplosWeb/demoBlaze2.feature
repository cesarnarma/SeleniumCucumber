@featurePruebasDemoBlaze2
Feature: Prueba Demo Blaze N.2

  @prueba2DemoBlaze @DemoBlaze2_1_1
  Scenario: Validar que al añadir un nuevo producto al carrito se actualiza correctamente
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Nokia lumia 1520"
    And obtengo el valor del producto seleccionado
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    Then valido que el producto añadido sea "Nokia lumia 1520"
    And valido que el costo del producto "Nokia lumia 1520" es el correcto

  @prueba2DemoBlaze @DemoBlaze2_1_2
  Scenario: Validar que el total del carrito coincide con el total de los productos en el
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Samsung galaxy s6"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Home"
    When realizo click sobre el producto "Nexus 6"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    Then valido que el total sea correcto segun la suma de los valores del carrito

  @prueba2DemoBlaze @DemoBlaze2_1_3
  Scenario: Validar que al presionar place order se muestra el formulario de compra
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Samsung galaxy s6"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    And realizo click sobre el boton "Place Order"
    Then valido que se muesta el formulario de compra

  @prueba2DemoBlaze @DemoBlaze2_1_4
  Scenario: Validar que al presionar purchase en el formulario de compra se muestra el mensaje esperado "Thank you for your purchase!"
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Samsung galaxy s6"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    And realizo click sobre el boton "Place Order"
    And ingreso "Cesar Narvaez" en el campo "Name:"
    And ingreso "Colombia" en el campo "Country:"
    And ingreso "Bogota" en el campo "City:"
    And ingreso "1234 4567 1263" en el campo "Credit card:"
    And ingreso "07" en el campo "Month:"
    And ingreso "2007" en el campo "Year:"
    And realizo click sobre el boton "Purchase"
    Then valido que se muestra el mensaje de exito "Thank you for your purchase!"

  @prueba2DemoBlaze @DemoBlaze2_1_5
  Scenario: Validar que al presionar purchase en el formulario de compra se muestra el mensaje esperado "Thank you for your purchase!"
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Samsung galaxy s6"
    And presiono el boton "Add to cart"
    And presiono aceptar sobre el alert
    And presiono el menu "Cart"
    And realizo click sobre el boton "Place Order"
    And realizo click sobre el boton "Purchase"
    Then valido que se muestra el mensaje de error "Please fill out Name and Creditcard."