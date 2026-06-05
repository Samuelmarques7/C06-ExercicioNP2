package br.com.inatel.entidades;

public interface Persistivel {
    // Quem assinar este contrato (implements) será obrigado a ter uma lógica de salvar dados
    void salvar();
}