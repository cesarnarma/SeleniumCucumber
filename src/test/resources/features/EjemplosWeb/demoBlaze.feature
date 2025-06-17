@featurePruebasDemoBlaze
Feature: Prueba Demo Blaze N.1

  @prueba1DemoBlaze @DemoBlaze1_1
  Scenario: Validar categorias en DemoBlaze - Phones
    Given estoy en la web de "https://demoblaze.com/"
    Then valido que existe la categoria de "Phones"

  @prueba1DemoBlaze @DemoBlaze1_2
  Scenario: Validar categorias en DemoBlaze - Laptops
    Given estoy en la web de "https://demoblaze.com/"
    Then valido que existe la categoria de "Laptops"

  @prueba1DemoBlaze @DemoBlaze1_3
  Scenario: Validar categorias en DemoBlaze - Monitors
    Given estoy en la web de "https://demoblaze.com/"
    Then valido que existe la categoria de "Monitors"

  @prueba1DemoBlaze_2 @DemoBlaze2_1
  Scenario: Validar que la categoria monitor no tiene menos de 2 productos - Monitors
    Given estoy en la web de "https://demoblaze.com/"
    When ingreso a la categoria "Monitors"
    Then valido que no existan menos de "2" productos

  @prueba1DemoBlaze_2 @DemoBlaze2_2
  Scenario: Validar que la categoria monitor no tiene menos de 2 productos - Laptops
    Given estoy en la web de "https://demoblaze.com/"
    When ingreso a la categoria "Laptops"
    Then valido que no existan menos de "2" productos

  @prueba1DemoBlaze_2 @DemoBlaze2_3
  Scenario: Validar que la categoria monitor no tiene menos de 2 productos - Phones
    Given estoy en la web de "https://demoblaze.com/"
    When ingreso a la categoria "Phones"
    Then valido que no existan menos de "2" productos

  @prueba1DemoBlaze_3 @DemoBlaze3_1
  Scenario: Validar que las categoria no tengan mas de 9 productos
    Given estoy en la web de "https://demoblaze.com/"
    When ingreso a la categoria "Laptops"
    Then valido que no existan mas de "9" productos

  @prueba1DemoBlaze_4 @DemoBlaze4_1
  Scenario: Validar titulo de la pestaña
    Given estoy en la web de "https://demoblaze.com/"
    Then valido que el nombre de la pestaña es "STORE"

  @prueba1DemoBlaze_5 @DemoBlaze5_1
  Scenario: Validar que al ingresar a un producto su ficha es la correcta
    Given estoy en la web de "https://demoblaze.com/"
    When realizo click sobre el producto "Iphone 6 32gb"
    Then valido que la ficha corresponde a "Iphone 6 32gb"