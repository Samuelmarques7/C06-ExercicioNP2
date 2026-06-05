package br.com.inatel.sensor;

public class SinalCriticoException extends Exception {
    private double valor;

    public SinalCriticoException(String mensagem, double valor) {
        super(mensagem);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}