package Computador;

import HardwareBasico.HardwareBasico;
import MemoriaUSB.MemoriaUSB;
import SistemaOperacional.SistemaOperacional;

public class Computador {

    private String marca;
    private float preco;
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;
    private HardwareBasico[] hardwaresBasicos;

    public Computador(String marca, float preco, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = sistemaOperacional;
        this.hardwaresBasicos = new HardwareBasico[3];
    }

    public void addHardwareBasico(HardwareBasico hardware, int posicao) {
        if (posicao >= 0 && posicao < hardwaresBasicos.length) {
            hardwaresBasicos[posicao] = hardware;
        }
    }

    public void addMemoriaUSB(MemoriaUSB usb) {
        this.memoriaUSB = usb;
    }

    public void mostraPCConfigs() {
        System.out.println("====================================");
        System.out.println("PC da marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        System.out.println("\n--- Hardware Básico ---");
        for (HardwareBasico hb : hardwaresBasicos) {
            if (hb != null) {
                System.out.println(hb.getNome() + ": " + hb.getCapacidade());
            }
        }

        System.out.println("\n--- Sistema Operacional ---");
        if (sistemaOperacional != null) {
            System.out.println(sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        }

        System.out.println("\n--- Memória USB ---");
        if (memoriaUSB != null) {
            System.out.println(memoriaUSB.getNome() + ": " + memoriaUSB.getCapacidade() + " GB");
        }

        System.out.println("====================================\n");
    }

    public float getPreco() {
        return preco;
    }
}