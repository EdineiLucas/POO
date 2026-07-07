Atividade Estruturada: Desafio SpaceShare (2,0 pts)


O Problema:


O sistema deve gerenciar estações de trabalho. Cada estação tem um limite de uso diário de 10 horas para evitar sobrecarga de energia e manutenção.

Requisitos Técnicos:

1.   Classe Reserva: Atributos: usuario (String), horas (int).
2.   Classe Estacao:

Atributos: numero (int), listaReservas (ArrayList).
Método boolean adicionarReserva(Reserva r):
Deve somar as horas das reservas já existentes.
Se a nova reserva + as existentes for menor que 10, adiciona e retorna true.
Caso contrário, rejeita e retorna false.
Método imprimirMapa(): Mostra o número da estação e todos os usuários que a ocuparão naquele dia.