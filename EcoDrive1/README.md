ATIVIDADE

        
Criar uma classe “motorista”, com nome e cnh

      
Conectar o motorista ao veículo


O Desafio: O sistema não deve permitir que uma viagem seja
registrada se o veículo não tiver um condutor vinculado.

Altere
o método registrarViagem(double distanciaKm) dentro da classe Veiculo.
Adicione
um if logo no início para verificar se o atributo condutor é igual a null.
Se
for null, exiba a mensagem: "Erro: Não é possível viajar sem um
motorista cadastrado!" e não realize a viagem.
Teste no main criando um motorista e
vinculando-o ao carro antes de viajar

NOVA ATIVIDADE


O Problema da "Troca de
Turno":


1.   No método setCondutor, antes de aceitar um novo motorista, o sistema deve verificar se já existe um motorista no carro.


2. Se já existir, o sistema deve "avisar" o motorista antigo que ele não está mais naquele carro (fazer antigoMotorista.setVeiculoAtual(null)) antes de colocar o novo.


3. Vamos assumir que nosso sistema de logística exige CNH categoria 'D' para dirigir os veículos da frota.
Portanto “categoria” deve ser também um atributo. Se o motorista não tiver essa categoria ele não pode dirigir.

Cenário

1. Criar um veículo e dois motoristas: Motorista A (Categoria B) e Motorista B (Categoria D).


2. Tentar vincular o Motorista A e mostrar que o sistema barrou (por causa da categoria).


3. Vincular o Motorista B e realizar uma viagem de 40km.

4. Exibir o status do veículo para confirmar que o motorista B está lá.