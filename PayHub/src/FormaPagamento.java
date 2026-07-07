/*
Representa o molde genérico de qualquer pagamento. Não deve ser possível instanciá-la diretamente.

    Atributos protegidos (protected): * double valorTotal
    String status (Deve iniciar como "PENDENTE")

Construtor: Deve receber o valorTotal.

    Validação de Segurança: Se o valor for menor ou igual a zero, lance imediatamente uma IllegalArgumentException com a mensagem "Valor do pagamento deve ser maior que zero.".

Método Abstrato: public abstract void processar();
 */
public abstract class FormaPagamento {
}
