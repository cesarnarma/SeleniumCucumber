@feacture_aserciones
Feature: Clase de Aserciones


  @testAserciones
  Scenario: Validar titulo en SouceDemo
    Given estoy en la web de "https://www.saucedemo.com/"
    Then valido que el titulo sea "Swag Labs"
