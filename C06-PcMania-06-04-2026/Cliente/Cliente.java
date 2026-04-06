package Cliente;

import Computador.Computador;

public class Cliente {

    private String nome;
    private String cpf;
    private Computador[] computadores = new Computador[3];
    private int contador = 0;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void addComputador(Computador computador) {
        if (contador < computadores.length) {
            computadores[contador] = computador;
            contador++;
        }
    }

    public int getQuantidadeComputadores() {
        return contador;
    }

    public float calculaTotalCompra() {
        if (contador < 2) {
            System.out.println("Erro: Cliente deve escolher no mínimo 2 computadores!");
            return 0;
        }
        float total = 0;
        for (int i = 0; i < contador; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }
}
