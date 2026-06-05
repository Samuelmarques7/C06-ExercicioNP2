package br.com.inatel.entidades;

import br.com.inatel.sensor.Sensor;
import java.util.ArrayList;
import java.util.List;

public class Leito {

    private int numero;
    private Paciente paciente;
    private List<Sensor> sensores;

    // Quando criamos o leito, ele só tem o número. O paciente e os sensores entram depois.
    public Leito(int numero) {
        this.numero = numero;
        this.sensores = new ArrayList<>(); // Prepara a lista vazia de sensores
    }

    // Método para internar o paciente neste leito
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Método para plugar um sensor no leito
    public void adicionarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    // Getters para o sistema conseguir ler os dados do leito depois
    public int getNumero() {
        return numero;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }
}