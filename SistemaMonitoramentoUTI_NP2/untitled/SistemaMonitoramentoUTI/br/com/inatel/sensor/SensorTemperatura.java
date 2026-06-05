package br.com.inatel.sensor; // Ajuste para t1 se necessário

public class SensorTemperatura extends Sensor {

    // O construtor avisa para a classe mãe que este é um sensor de Temperatura
    public SensorTemperatura() {
        super("Temperatura");
    }

    // Polimorfismo: Reescrevendo o método da classe mãe do jeito específico da Temperatura
    @Override
    public double lerSinal() throws SinalCriticoException {
        // Gera uma temperatura aleatória entre 34.0 e 40.0
        double valor = 34.0 + (Math.random() * 6.0);

        // Se a temperatura passar de 39 ou cair abaixo de 35, dispara a sua exceção!
        if (valor > 39.0 || valor < 35.0) {
            throw new SinalCriticoException("Temperatura Crítica!", valor);
        }

        return valor; // Se estiver tudo bem, só retorna o valor normal
    }
}