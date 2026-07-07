Para consolidar o entendimento sobre Identidade de Objetos (equals e hashCode) e o comportamento de Coleções (HashSet).

Atividade 1: A Identidade do Veículo (Foco em Regra de Negócio)
O Problema: No sistema da sua startup de logística, um veículo é único pela sua placa. Atualmente, o sistema permite cadastrar dois veículos com a mesma placa se os objetos forem instanciados separadamente.
Tarefa:

Na classe Veiculo (ou crie uma nova se preferir), implemente os métodos equals e hashCode. 
A regra de igualdade deve considerar apenas a placa.
No método main, crie um HashSet<Veiculo>.
Tente adicionar dois veículos:
v1 (Placa: "IFN-2026", Cor: "Azul")
v2 (Placa: "IFN-2026", Cor: "Preto")
Validação: O HashSet deve conter apenas 1 veículo ao final. Se houver 2, a implementação falhou.

Atividade 2: Desafio "Combo" SpaceShare (Integração Total)
O Problema: No sistema de Coworking, não podemos permitir que uma Reserva seja exatamente igual a outra (mesmo usuário e mesma hora de início) para evitar erros de processamento.
Requisitos Técnicos:

Implementar equals e hashCode na classe Reserva usando os atributos usuario e horaInicio.
Na classe Estacao, altere o tipo da listaReservas de ArrayList para HashSet.
No método adicionarReserva, remova o for que verificava duplicatas e use apenas o método .add() do HashSet.
Desafio: Capture o retorno do método .add(). Se for false, exiba uma mensagem: "Reserva ignorada: este agendamento já existe".