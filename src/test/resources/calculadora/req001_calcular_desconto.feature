# language: pt
@all @req001 @cliente
Funcionalidade: Calcular desconto

  @sucesso
  Esquema do Cenario: Calcular desconto com sucesso (fluxo básico)

    Dado que eu acesso a opção "calcular desconto"
    E seleciono o produto
    Quando preencho com dados do cliente
      | cliente       | <cliente>       |
      | quantidade    | <quantidade>    |
      | fatoresperado | <fatoresperado> |
    E calculo o desconto
    Então verifico se a mensagem foi exibida com sucesso

    Exemplos:
      | cliente | quantidade | fatoresperado                  |
      | A       | 99         | 0,9  (10% de desconto)         |
      | A       | 100        | 0.95 (5% de desconto)          |
      | A       | 999        | 0.95 (5% de desconto)          |
      | A       | 1000       | 1,00 (0% de desconto)          |
      | A       | 2000       | 1,00 (0% de desconto)          |
      | B       | 100        | 0.9  (ou seja,10% de desconto) |
      | B       | 99         | 0,85 (ou seja,15% de desconto) |
      | B       | 1000       | 0,95 (ou seja,5% de desconto)  |

  @falha
  Esquema do Cenario: Calcular desconto sem sucesso (fluxo alt)

    Dado que eu acesso a opção "calcular desconto"
    E seleciono o produto
    Quando preencho com dados do cliente
      | cliente       | <cliente>       |
      | quantidade    | <quantidade>    |
      | fatoresperado | <fatoresperado> |
    E calculo o desconto
    Então verifico se a mensagem de erro foi exibida

    Exemplos:
      | cliente | quantidade | fatoresperado         |
      | A       | 0          | 1,00 (0% de desconto) |
      | A       | -1         | 1,00 (0% de desconto) |
      | A       | X          | 1,00 (0% de desconto) |
      | A       | 0.5        | 1,00 (0% de desconto) |
      | A       | Abc123     | 1,00 (0% de desconto) |
