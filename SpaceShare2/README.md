O Problema:

O limite de 10 horas totais foi removido. Agora, a empresa permite que a Estação seja usada a qualquer momento, desde que dois usuários não reservem o mesmo horário simultaneamente.

Requisitos Técnicos:

1. Classe Reserva (Atualizada)
        
Atributos: usuario (String), horaInicio (LocalTime), duracaoHoras (int).
Método getHoraTermino(): Deve retornar um LocalTime somando a horaInicio com a duracaoHoras. (Dica: Use horaInicio.plusHours(duracaoHoras)).

2. Classe Estacao (Atualizada)
        
Método boolean adicionarReserva(Reserva nova):

Deve percorrer a listaReservas existente.
Para cada reserva já salva, verificar se há sobreposição com a nova.
Lógica do Conflito: Há conflito se (Nova_Inicio < Existente_Termino) E (Nova_Termino > Existente_Inicio).
Se houver conflito, exiba o erro, não adicione e retorne false.
Caso contrário, adicione e retorne true.

3. Cenário de Teste Obrigatório (No main)

Tentem realizar as seguintes reservas nesta ordem:
1. Reserva 1: João, às 08:00, por 2 horas. (Dever ser Aceita)
2. Reserva 2: Maria, às 09:00, por 2 horas. (Deve ser Negada - conflita com João das 09h às 10h)
3. Reserva 3: Carlos, às 10:00, por 1 hora. (Deve ser Aceita - João termina exatamente às 10h)
4. Reserva 4: Ana, às 07:00, por 4 horas. (Deve ser Negada - atropela a reserva do João)