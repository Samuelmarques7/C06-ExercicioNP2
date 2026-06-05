package br.com.inatel.threads;

import br.com.inatel.entidades.Alerta;
import br.com.inatel.entidades.Leito;
import br.com.inatel.sensor.Sensor;
import br.com.inatel.sensor.SinalCriticoException;

public class MonitorLeito extends Thread {

    private Leito leito;
    private boolean rodando;

    public MonitorLeito(Leito leito) {
        this.leito = leito;
        this.rodando = true;
    }

    // Método para desligar o monitor
    public void parar() {
        this.rodando = false;
    }

    @Override
    public void run() {
        System.out.println("-> Iniciando monitoramento do Leito " + leito.getNumero());

        // Fica rodando em loop infinito até chamarem o método parar()
        while (rodando) {

            // Passa por todos os sensores conectados neste leito
            for (Sensor sensor : leito.getSensores()) {
                try {
                    // Tenta ler o sinal do paciente
                    double valor = sensor.lerSinal();
                    System.out.printf("[Leito %d] %s: %.1f - OK\n", leito.getNumero(), sensor.getTipo(), valor);

                } catch (SinalCriticoException e) {
                    // Se a exceção for disparada, cai aqui no catch (Tratamento de Erros)
                    System.out.printf("[Leito %d] *** ALERTA: %s ***\n", leito.getNumero(), e.getMessage());

                    // Cria e salva o alerta no arquivo .txt
                    String mensagemErro = e.getMessage() + " (Valor: " + String.format("%.1f", e.getValor()) + ")";
                    Alerta alerta = new Alerta(sensor.getTipo(), mensagemErro, leito.getPaciente().getId());
                    alerta.salvar();
                }
            }

            // O Thread.sleep manda o sistema pausar (ex: 3 segundos) antes de ler tudo de novo
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Monitoramento interrompido.");
            }
        }
    }
}