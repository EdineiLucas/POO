/*
Vocês foram contratados para arquitetar o motor de pagamentos de uma nova plataforma de E-commerce.
o sistema não pode aceitar dados corrompidos, não pode perder dinheiro e precisa tratar erros de forma
inteligente para que a experiência do usuário não seja interrompida se um cartão for recusado.

O sistema deverá ser composto por 5 arquivos principais: uma interface, uma classe abstrata, duas classes concretas e uma classe principal de teste

ara obterem a nota máxima, vocês precisarão implementar o recurso Try-with-Resources do Java para simular a abertura e o fechamento de uma Conexão de Gateway de Pagamento.
O que pesquisar e implementar:

Crie uma classe simples chamada GatewayPagamento que implementa a interface nativa do Java AutoCloseable.
Essa classe deve ter um método void conectar() que imprime "Conectando ao servidor de cartões...".
O método close() (exigido pela interface) deve imprimir "Conexão com o gateway encerrada com segurança.".
No método processar() da classe PagamentoCartao, vocês devem usar o bloco try-with-resources para garantir que o gateway seja aberto,
usado e fechado automaticamente, mesmo se o cartão disparar a exceção de saldo insuficiente..


Na classe principal, vocês devem simular uma fila de transações de um carrinho de compras. O objetivo é provar que o Polimorfismo funciona e que o sistema é resiliente
(um erro em um pagamento não pode derrubar o sistema inteiro).Instruções para o Main:

Crie uma lista: ArrayList<FormaPagamento> carrinho = new ArrayList<>();
Adicione 4 pagamentos na lista:
Um Pix válido.
Um Pix inválido (chave vazia).
Um Cartão válido.
Um Cartão com início "4444" (saldo insuficiente).
 */
public class PayHub {
}
