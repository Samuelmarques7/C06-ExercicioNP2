package br.com.inatel.entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Alerta implements Persistivel {

    private String tipo;
    private String mensagem;
    private String idPaciente;

    public Alerta(String tipo, String mensagem, String idPaciente) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.idPaciente = idPaciente;
    }

    @Override
    public void salvar() {

        try (FileWriter fw = new FileWriter("alertas_uti.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {

            // Escreve a linha no arquivo de texto
            pw.println("ALERTA [" + tipo + "] | Paciente ID: " + idPaciente + " | Motivo: " + mensagem);

            // Avisa no console do IntelliJ que deu certo
            System.out.println("-> Registro salvo em arquivo (alertas_uti.txt)!");

        } catch (IOException e) {
            // Se o Windows/Mac não deixar criar o arquivo (ex: falta de permissão), cai no "catch"
            System.out.println("Erro crítico ao salvar o arquivo: " + e.getMessage());
        }
    }
}