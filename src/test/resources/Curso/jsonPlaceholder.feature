#language: pt
  Funcionalidade: test post

    @Tag1
    Esquema do Cenario: Cenario: teste1<cenario>
      Dado que acesso a url "https://jsonplaceholder.typicode.com" com o endpoint "/posts"
      Quando preencho campo "titulo" com "testeServicos" no objeto json
      E preencho o campo "nome" com "<nome>" no objeto cliente
      E preencho o campo "idade" com "28" no objeto cliente
      E preencho o campo "nome" com "kelly" no objeto clienteDois
      E preencho o campo "idade" com "33" no objeto clienteDois
      E adiciono o objeto  cliente na lista clientes
      E adiciono o objeto clienteDois na lista clientes
      E adiciono o campo "cliente" com lista clientes no objeto json
      E realizo a requisicao post
      Entao valido que o campo "cliente[0].nome" recebo o valor "roberto"
      E valido que o campo "cliente[0].idade" recebo o valor "28"
      E valido que o campo "cliente[1].nome" recebo o valor "kelly"
      E valido que o campo "cliente[1].idade" recebo o valor "33"

      Exemplos:
      |<nome>|<idade>|
      |"roberto"|"28"|
      |"kelly"|"33"|
      |"ivina"|"32"|
      |"ivonete"|"65"|
      |"painho"|"63"|