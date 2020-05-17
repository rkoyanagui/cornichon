#language: pt
@google
Funcionalidade: Busca no Google

  Esquema do Cenário: Busca no Google
    Dado que estou na página inicial do Google
    Quando preencho o campo de busca com "<frase_de_busca>"
    Então Google deve exibir os resultados da busca
    Exemplos:
      | frase_de_busca |
      | cheese         |
      | milk           |
