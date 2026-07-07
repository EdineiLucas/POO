Atividade Prática: Desafio de Especialização (2,0 pts)


O Cenário:
O coworking agora possui um novo tipo de espaço: a Cabine de Call. Ela é uma estação pequena, para apenas uma pessoa, mas possui isolamento acústico.

O que você deve fazer:

1.   Criar a classe CabineCall:

Deve herdar de Estacao.
Deve possuir um atributo próprio: boolean isolamentoAcustico.
Deve implementar um método entrarEmChamada() que só imprime "Silêncio ativado" se o isolamento for true.

2.   No main (Classe Principal):

Instanciar uma SalaReuniao (Número 501, 10 pessoas, com projetor).
Instanciar uma CabineCall (Número 10, com isolamento).
O desafio: Você deve adicionar uma Reserva em ambos os objetos.

Nota: Como as duas classes herdaram de Estacao, elas já possuem automaticamente o método adicionarReserva e a listaReservas que criamos na aula anterior.