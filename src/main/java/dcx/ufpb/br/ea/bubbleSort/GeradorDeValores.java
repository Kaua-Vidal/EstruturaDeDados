package dcx.ufpb.br.ea.bubbleSort;

import javax.swing.*;
import java.util.Scanner;

public class GeradorDeValores {

    static int vetor[];

    public static boolean pertence(int valor, int tam){
        for (int i=0; i<tam; i++){
            if (vetor[i] == valor){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        vetor = new int[Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor: "))];
        //System.out.println("Criei um vetor de tamanho: "+vetor.length);

        int valor, pos;

        //gerei valores aleatórios
        for (pos=0; pos<vetor.length;pos++){
            do{
               valor = (int) (Math.random()*100000) % 100000;
            } while (pertence(valor, pos));
            vetor[pos] = valor;
        }

        //imprimir
        AlgoritmosDeOrdanacao alg = new AlgoritmosDeOrdanacao();
            System.out.println("-------- Ordenando Vetor ----------");
            System.out.println("");
            alg.setVetor(vetor);
            alg.bubbleSort();
            alg.mostraVetor();


    }
}
