package br.com.inatel.sensor;

public abstract class Sensor {

    // protected permite que apenas as classes filhas vejam e modifiquem essa variável
    protected String tipo;

    public Sensor(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    // Método abstrato: não tem corpo {}.
    // Ele obriga cada sensor filho a criar a sua própria lógica de gerar o número e disparar o alerta.
    public abstract double lerSinal() throws SinalCriticoException;
}