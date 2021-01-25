# language: pt

@all @req003
Funcionalidade: REQ003 - Mensagem de Contato

  Contexto: Acesso à página de Mensagem de Contato
    Dado que estou na página inicial do sistema
    E acesso a opção contato

  Cenário: Enviar Contato com Sucesso: Dúvida, menor que 18 anos
    Quando preencho os dados no formulário de contato
      | nome      | José da Silva Miguel     |
      | email     | josedasilva@gmailsdf.com |
      | tipo_msg  | DÚVIDA                   |
      | idade     | Menor que 18 anos        |
      | texto_msg | Tenho uma dúvida pequena |
    E envio o formulário de contato
    Então verifico que a mensagem "Sucesso no envio da mensagem" foi exibida na página
