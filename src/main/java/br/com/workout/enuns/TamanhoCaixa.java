package br.com.workout.enuns;

public enum TamanhoCaixa {

    CAIXA_1(30, 40, 80),
    CAIXA_2(80, 50, 40),
    CAIXA_3(50, 80, 60);

    private final int altura;
    private final int largura;
    private final int comprimento;

    TamanhoCaixa(int altura, int largura, int comprimento) {
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

}
