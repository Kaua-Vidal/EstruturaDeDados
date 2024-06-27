package dcx.ufpb.br.ea.pilhaDinamica;

import dcx.ufpb.br.ea.pilhas.PilhaTeste;

import javax.swing.*;

public class Conversor {
    public static void main(String[] args) {
        StringBuilder binario = new StringBuilder();
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));

        IPilha p;

        String opcao = JOptionPane.showInputDialog("Qual tipo de pilha você quer? " +
                "\n1.pilha" +
                "\n2.Pilha dinamica");

        if (opcao.equals("1")){
            p = new Pilha();
            JOptionPane.showMessageDialog(null, "Pilha selecionada.");
        } else if (opcao.equals("2")){
            p = new PilhaDinamica();
            JOptionPane.showMessageDialog(null, "Pilha Dinâmica selecionada.");
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida! tente novamente.");
            return;
        }


        try {
            int resto;

            while (numero != 0) {
                resto = numero % 2;
                p.push(resto);
                numero = numero / 2;
            }

            while (!p.isEmpty()) {
                resto = p.pop();
                binario.append(resto);
            }
            JOptionPane.showMessageDialog(null, "Número: "+numero+"\nEm binário: " + binario.toString());
            JOptionPane.showMessageDialog(null,"Fim!");

        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Deu ruim...");
        }

    }
}
