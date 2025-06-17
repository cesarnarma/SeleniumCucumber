@feacture2
Feature: Clase de localizadores


  @testLocalizadores
  Scenario: Validar login en pagina ejemplo
    Given estoy en la web de "https://www.saucedemo.com/"
    When ingreso el username "standard_user"
    And ingreso el password "secret_sauce"
    And presiono el boton Login
    Then valido que me he logeado en el sitio de ejemplo