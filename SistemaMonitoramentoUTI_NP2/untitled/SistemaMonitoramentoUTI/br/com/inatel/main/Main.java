package br.com.inatel.main;

import br.com.inatel.entidades.Leito;
import br.com.inatel.entidades.Paciente;
import br.com.inatel.sensor.SensorFreqCardiaca;
import br.com.inatel.sensor.SensorTemperatura;
import br.com.inatel.threads.MonitorLeito;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE MONITORAMENTO DE UTI INICIADO ---\n");

        // 1. Criando 3 pacientes (Critério do seu projeto)
        Paciente p1 = new Paciente("P001", "João Silva", 65, "Pós-operatório Cardíaco");
        Paciente p2 = new Paciente("P002", "Maria Souza", 72, "Pneumonia Severa");
        Paciente p3 = new Paciente("P003", "Carlos Mendes", 50, "Trauma Crânio-Encefálico");

        // 2. Criando 3 leitos e internando os pacientes
        Leito leito1 = new Leito(1);
        leito1.setPaciente(p1);

        Leito leito2 = new Leito(2);
        leito2.setPaciente(p2);

        Leito leito3 = new Leito(3);
        leito3.setPaciente(p3);

        // 3. Adicionando os sensores (2 para cada leito)
        leito1.adicionarSensor(new SensorTemperatura());
        leito1.adicionarSensor(new SensorFreqCardiaca());

        leito2.adicionarSensor(new SensorTemperatura());
        leito2.adicionarSensor(new SensorFreqCardiaca());

        leito3.adicionarSensor(new SensorTemperatura());
        leito3.adicionarSensor(new SensorFreqCardiaca());

        // 4. Criando os monitores de cada leito (Threads)
        MonitorLeito monitor1 = new MonitorLeito(leito1);
        MonitorLeito monitor2 = new MonitorLeito(leito2);
        MonitorLeito monitor3 = new MonitorLeito(leito3);

        // 5. Dando o PLAY nas Threads (.start() faz elas rodarem em paralelo)
        monitor1.start();
        monitor2.start();
        monitor3.start();

        // 6. Deixa o sistema rodar sozinho por 15 segundos para a sua apresentação
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Sistema interrompido.");
        }

        // 7. Desliga tudo
        System.out.println("\n--- DESLIGANDO MONITORES ---");
        monitor1.parar();
        monitor2.parar();
        monitor3.parar();
        System.out.println("Monitoramento encerrado. Verifique o arquivo alertas_uti.txt para o histórico de emergências.");
    }
}