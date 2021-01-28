# language: pt

@all @req003 @contato
Funcionalidade: REQ003 - Mensagem de Contato

  Contexto: Acesso à página de Mensagem de Contato
    Dado que eu acesso a opção "contato"

  @sucesso
  Esquema do Cenario: Enviar contato com sucesso (fluxo básico)
    Quando preencho com dados válidos o formulário
      | nome  | <nome>     |
      | email | <email>    |
      | tipo  | <tipo>     |
      | idade | <idade>    |
      | msg   | <mensagem> |
    E submeto o formulário de contato
    Então verifico que a mensagem "Sucesso no envio da mensagem" foi exibida na página

    Exemplos:
      | nome  | email             | tipo   | idade             | mensagem        |
      | Maria | maria@yopmail.com | DÚVIDA | Menor que 18 anos | Dúvida de Maria |
#      | Carlos | carlos@yopmail.com | DÚVIDA     | Entre 18 e 29 anos  | Dúvida de Carlos |
#      | João   | joao@yopmail.com   | DÚVIDA     | Entre 30 e 64 anos  | Dúvida de João   |
#      | Alison | alison@yopmail.com | DÚVIDA     | A partir de 65 anos | Dúvida de Alison |
#      | Maria  | maria@yopmail.com  | SUGESTÃO   | Menor que 18 anos   | Dúvida de Maria  |
#      | Carlos | carlos@yopmail.com | SUGESTÃO   | Entre 18 e 29 anos  | Dúvida de Carlos |
#      | João   | joao@yopmail.com   | SUGESTÃO   | Entre 30 e 64 anos  | Dúvida de João   |
#      | Alison | alison@yopmail.com | SUGESTÃO   | A partir de 65 anos | Dúvida de Alison |
#      | Maria  | maria@yopmail.com  | RECLAMAÇÃO | Menor que 18 anos   | Dúvida de Maria  |
#      | Carlos | carlos@yopmail.com | RECLAMAÇÃO | Entre 18 e 29 anos  | Dúvida de Carlos |
#      | João   | joao@yopmail.com   | RECLAMAÇÃO | Entre 30 e 64 anos  | Dúvida de João   |
#      | Alison | alison@yopmail.com | RECLAMAÇÃO | A partir de 65 anos | Dúvida de Alison |

  @falha
  Cenário: Enviar formulário sem preencher os dados
    Quando submeto o formulário de contato
    Então verifico que a mensagem "Erro" foi exibida na página
