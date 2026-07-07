package classesABeInterface;

public interface Promocional {
    // Repare que o "contrato" desta interface so promete aplicarDesconto.
    // getNumero() NAO existe aqui, por isso uma referencia do tipo
    // Promocional nao consegue chamar promo.getNumero(), mesmo que o
    // objeto real (CabineCall) tenha esse metodo.
    void aplicarDesconto(double percentual);
}

