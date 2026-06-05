package br.com.inatel.entidades;

public class Paciente {

    private String id;
    private String nome;
    private int idade;
    private String diagnostico;

    public Paciente(String id, String nome, int idade, String diagnostico) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.diagnostico = diagnostico;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    // Método customizado simples, no lugar do toString().
    // Ele junta o nome e o diagnóstico em um texto só.
    public String getResumo() {
        return nome + " (" + diagnostico + ")";
    }
}