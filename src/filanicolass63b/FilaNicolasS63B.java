/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filanicolass63b;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class FilaNicolasS63B {

    public static void main(String[] args) {
        Scanner lerDados = new Scanner(System.in);
        Fila<Processo> fila = new Fila<>();
        Random aleatorio = new Random();
        int teste;
        do {      
            do {                
                System.out.println("Criando os processos...");
                for (int i = 0; i < 10; i++) {
                    fila.enfileirar(new Processo(i, aleatorio.nextInt(200) + 10));
                }
                System.out.println("Os processos são:");
                System.out.println(fila);
                System.out.println("Continuar?\n1- Sim\n2- Gerar novos processos\n3- Sair");
                teste = lerDados.nextInt();
                if (teste==2) {
                    for (int i = 0; i < 10; i++) {
                        fila.desenfileirar();
                    }
                }
            } while (teste==2);
            if (teste==1) {
                System.out.println("Executando processos...");
                do {
                    Processo pro = fila.desenfileirar();
                    System.out.println("Executando o processo:\n" + pro);
                    if (pro.executa()) {
                        fila.enfileirar(pro);
                        try {
                            Thread.sleep(aleatorio.nextInt(500) + 500);
                        } catch (InterruptedException ex) {
                        }
                    }
                    System.out.println(fila);
                } while (fila.estaVazia() == false);
            }
        } while (teste==1 || teste==2);		
    }
}
