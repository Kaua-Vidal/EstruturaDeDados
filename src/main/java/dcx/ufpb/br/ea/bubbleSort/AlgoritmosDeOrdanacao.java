package dcx.ufpb.br.ea.bubbleSort;

public class AlgoritmosDeOrdanacao {

    private int vetor[] = {25, 57, 48, 37, 12, 92, 33};

    public void setVetor(int vetor[]){
        this.vetor = vetor;
    }

    public void bubbleSort(){
        int it;           //numero de iterações
        int pos;          //sempre uso a posição atual
        int temp;         //variável para a troca

        System.out.println("Realizando BubbleSort em um vetor de "+vetor.length+ " elementos");

        for (it=0; it <vetor.length; it++){
            for (pos =0; pos <vetor.length - it - 1; pos++){
                if (vetor[pos] > vetor[pos+1]){        //compara se o próximo é maior
                    temp = vetor[pos];
                    vetor[pos] = vetor[pos+1];
                    vetor[pos+1] = temp;
                }
            }

            System.out.println("---------->  Fim da iteração "+it);
            mostraVetor();
        }
    }

    public void mostraVetor(){
        for (int i=0; i<vetor.length;i++){
            System.out.print(vetor[i]+" ");
        }
        System.out.println("");
    }
}
