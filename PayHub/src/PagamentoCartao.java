/*
Herda de FormaPagamento e implementa EmitenteNotaFiscal.

 Atributos privados: String numeroCartao, int parcelas.
 Construtor: Recebe o valor, o número do cartão e as parcelas. Passa o valor para o construtor do pai (super).
 Método processar() (Sobrescrita): Regra de Negócio: Se o número do cartão começar com "4444" (simulando um cartão sem limite),
 o método deve lançar uma exceção customizada chamada SaldoInsuficienteException.
 Caso contrário, altera o status para "APROVADO".

 Método emitirNFe() (Implementação): Deve exibir na tela os dados do faturamento,
 mascarando o cartão (ex: Cartão: **** **** **** 1234) e exibindo o valor do imposto retido (calcule $15\%$ sobre o valorTotal).
 */
public class PagamentoCartao {
}
