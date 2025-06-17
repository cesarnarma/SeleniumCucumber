@feacture1
Feature: Primera automatización


  @testGoogle @pruebasEnGoogle
  Scenario: Validar una busqueda en google
    Given estoy en Google
    When ingreso "Comida Tipica de China" en el campo de busqueda
    And presiono el boton buscar
    Then valido que en los resultados aparece "Comida Tipica de China"

  @testGoogle2 @pruebasEnGoogle
  Scenario: Validar una busqueda en google parte 2
    Given estoy en Google
    When ingreso "Lego" en el campo de busqueda
    And presiono el boton buscar
    Then valido que en los resultados aparece "Lego"

