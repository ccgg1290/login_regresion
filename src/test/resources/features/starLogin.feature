

@regresion
Feature: I want login BancofalabellaEmpresas

  Background:
    Given I want enter to Bancofalabella Empresas

  @Loginsuccesfull
  Scenario Outline: Login succesful Bancofalabella Empresas

    When I log in with correct credentials
      | ClienteEmpresarial   | TipoDeIdentificación   | NúmeroDeIdentificación   | ClavePersonal   | ClaveToken   |
      | <ClienteEmpresarial> | <TipoDeIdentificación> | <NúmeroDeIdentificación> | <ClavePersonal> | <ClaveToken> |
    Then See my name in the home page
      | NameUser   |
      | <NameUser> |
    Examples:
      | NameUser                 | ClienteEmpresarial | TipoDeIdentificación | NúmeroDeIdentificación | ClavePersonal | ClaveToken |
      | Dayana Andrea Rojas Alba | 23534              | Cédula de Ciudadanía | 1049653008             | 976431        | 4500023170 |


  @LoginIncorrectCredentials
  Scenario Outline: Login Unsuccesful incorrect credentials
    When I log in with incorrect credentials
      | NameUser   | ClienteEmpresarial   | TipoDeIdentificación   | NúmeroDeIdentificación   | ClavePersonal   | ClaveToken   |
      | <NameUser> | <ClienteEmpresarial> | <TipoDeIdentificación> | <NúmeroDeIdentificación> | <ClavePersonal> | <ClaveToken> |
    Then see error Los datos ingresados no son validos
    Examples:
      | NameUser                 | ClienteEmpresarial | TipoDeIdentificación | NúmeroDeIdentificación | ClavePersonal | ClaveToken |
      | Dayana Andrea Rojas Alba | 111111111111111    | Rut                  | 111111111111           | 976431        | 4500023170 |



  @LoginWithEmptyFields
  Scenario Outline: Login Unsuccesful with empty fields
    When I enter with empty fields
      | NameUser   | ClienteEmpresarial   | TipoDeIdentificación   | NúmeroDeIdentificación   | ClavePersonal   | ClaveToken   |
      | <NameUser> | <ClienteEmpresarial> | <TipoDeIdentificación> | <NúmeroDeIdentificación> | <ClavePersonal> | <ClaveToken> |
    Then see error Los datos ingresados no son validos
    Examples:
      | NameUser                 | ClienteEmpresarial | TipoDeIdentificación | NúmeroDeIdentificación | ClavePersonal | ClaveToken |
      | Dayana Andrea Rojas Alba |      212321554|      Rut            |              | 976431        | 4500023170 |



  @SpecialCharactersInSomeField
  Scenario Outline: Login Unsuccesful special characters in some field
    When I enter special characters in some field
      | NameUser   | ClienteEmpresarial   | TipoDeIdentificación   | NúmeroDeIdentificación   | ClavePersonal   | ClaveToken   |
      | <NameUser> | <ClienteEmpresarial> | <TipoDeIdentificación> | <NúmeroDeIdentificación> | <ClavePersonal> | <ClaveToken> |
    Then see error Los datos ingresados no son validos
    Examples:
      | NameUser                 | ClienteEmpresarial | TipoDeIdentificación | NúmeroDeIdentificación | ClavePersonal | ClaveToken |
      | Dayana Andrea Rojas Alba |       Ñ%&#~       | Rut                  | 1049653008             | 976431        | 4500023170 |



