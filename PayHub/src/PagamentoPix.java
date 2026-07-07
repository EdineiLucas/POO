/*
Herda de FormaPagamento. Não emite nota fiscal por este canal.

 Atributos privados: String chavePix.
 Construtor: Recebe o valor e a chave Pix.
 Método processar() (Sobrescrita): * Regra de Negócio: Se a chave Pix for vazia ("") ou nula (null),
 o método deve lançar uma exceção customizada chamada ChavePixInvalidaException.

 Caso contrário, altera o status para "APROVADO".
 */
public class PagamentoPix {
}
