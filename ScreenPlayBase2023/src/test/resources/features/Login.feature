@Login
Feature: Se desea ingresar a la aplicacion Eribank
  As Nicolas
  I want login into eribank
  So that I can used the app

  @LoginExitoso
  Scenario Outline: Se desea realizar login exitoso eribank para poder verificar el balance
    Given que Nicolas desea abrir la aplicacion eribank
    When se ingresan credenciales correctamente
      |usuario|contrasena|
      |<usuario>|<contrasena>|
    Then podremos visualizar la pantalla de home y ver nuestro balance <mensaje>

    Examples:
      |usuario|contrasena|mensaje|
      |company|company    |Your balance is: 100,00$|

