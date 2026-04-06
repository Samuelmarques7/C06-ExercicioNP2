package Main;

import Cliente.Cliente;
import Computador.Computador;
import HardwareBasico.HardwareBasico;
import MemoriaUSB.MemoriaUSB;
import ProcessarPedido.ProcessarPedido;
import SistemaOperacional.SistemaOperacional;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int MATRICULA = 535; // troque pela sua matrícula real

        Computador computador1 = new Computador(
                "Apple",
                MATRICULA,
                new SistemaOperacional("macOS Sequoia", 64)
        );
        computador1.addHardwareBasico(new HardwareBasico("Processador Core i3", 2200), 0);
        computador1.addHardwareBasico(new HardwareBasico("Memória RAM", 8), 1);
        computador1.addHardwareBasico(new HardwareBasico("HD", 500), 2);
        computador1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        Computador computador2 = new Computador(
                "Samsung",
                MATRICULA + 1234,
                new SistemaOperacional("Windows 8", 64)
        );
        computador2.addHardwareBasico(new HardwareBasico("Processador Core i5", 3370), 0);
        computador2.addHardwareBasico(new HardwareBasico("Memória RAM", 16), 1);
        computador2.addHardwareBasico(new HardwareBasico("HD", 1000), 2);
        computador2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        Computador computador3 = new Computador(
                "Dell",
                MATRICULA + 5678,
                new SistemaOperacional("Windows 10", 64)
        );
        computador3.addHardwareBasico(new HardwareBasico("Processador Core i7", 4500), 0);
        computador3.addHardwareBasico(new HardwareBasico("Memória RAM", 32), 1);
        computador3.addHardwareBasico(new HardwareBasico("HD", 2000), 2);
        computador3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        Cliente cliente1 = new Cliente("Samuel Marques", "123.456.789-00");

        Scanner entrada = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo à PCMania!");
        System.out.println("Escolha no mínimo 2 computadores para finalizar a compra.");
        System.out.println("1 - Promoção Apple");
        System.out.println("2 - Promoção Samsung");
        System.out.println("3 - Promoção Dell");
        System.out.println("0 - Finalizar compra");

        do {
            System.out.print("\nDigite o código da promoção desejada (1, 2, 3) ou 0 para finalizar: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente1.addComputador(computador1);
                    System.out.println("Promoção Apple adicionada!");
                    break;
                case 2:
                    cliente1.addComputador(computador2);
                    System.out.println("Promoção Samsung adicionada!");
                    break;
                case 3:
                    cliente1.addComputador(computador3);
                    System.out.println("Promoção Dell adicionada!");
                    break;
                case 0:
                    if (cliente1.getQuantidadeComputadores() < 2) {
                        System.out.println("Você precisa escolher pelo menos 2 computadores antes de finalizar!");
                    }
                    break;
                default:
                    System.out.println("Código inválido! Digite 1, 2, 3 ou 0.");
            }

        } while (opcao != 0 || cliente1.getQuantidadeComputadores() < 2);

        float total = cliente1.calculaTotalCompra();

        System.out.println("\n=========== RESUMO DA COMPRA ===========");
        System.out.println("Cliente: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());

        for (Computador c : cliente1.getComputadores()) {
            if (c != null) {
                c.mostraPCConfigs();
            }
        }

        System.out.println("Total da compra: R$ " + total);
        System.out.println("========================================");

        ProcessarPedido.enviarPedido(cliente1.getComputadores());

        entrada.close();
    }
}