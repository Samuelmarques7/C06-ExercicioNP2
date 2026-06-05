package br.com.inatel.sensor; // Ajuste para t1 se necessário

public class SensorFreqCardiaca extends Sensor {

    public SensorFreqCardiaca() {
        super("Frequencia Cardiaca");
    }

    @Override
    public double lerSinal() throws SinalCriticoException {
        // Gera batimentos aleatórios entre 40 e 140 bpm
        double valor = 40.0 + (Math.random() * 100.0);

        // Se o coração bater mais de 120 ou menos de 50, dispara o alerta
        if (valor > 120.0 || valor < 50.0) {
            throw new SinalCriticoException("Batimento Cardíaco Crítico!", valor);
        }

        return valor;
    }
}