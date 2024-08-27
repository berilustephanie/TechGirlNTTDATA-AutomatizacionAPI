Feature: Orden

  @test1
  Scenario Outline: Crear Ordenes
    When Creo la orden con el id <id>, petId <petId>, quantity <quantity>
    Then el código de respuesta es <statusCode>
    And el status es "<status>"

    Examples:
      | id | petId | quantity | statusCode | status  |
      | 1  | 1     | 2        | 200        | placed  |
      | 2  | 2     | 1        | 200        | placed  |
      | 3  | 3     | 5        | 200        | placed |

  @test2
  Scenario Outline: Obtener Ordenes
    When Obtengo la orden con el id <id>
    Then el código de respuesta es <statusCode>
    And el status es "<status>"

    Examples:
      | id | statusCode | status  |
      | 1  | 200        | placed  |
      | 2  | 200        | placed  |
      | 3  | 200        | placed |