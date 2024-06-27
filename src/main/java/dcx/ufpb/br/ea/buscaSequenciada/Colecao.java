package dcx.ufpb.br.ea.buscaSequenciada;

public class Colecao {

    private int valores[] = {12, 16, 23, 24, 32, 53, 54, 123, 512};

    public int BuscaSequenciada(int val){
        int pos;
        for (pos = 0; pos < valores.length; pos++){
            if (val == valores[pos]){
                return pos;
            }
        }
        return -1;

    }

    public int BuscaBinaria(int val){
        int meio, inicio, fim;
        inicio = 0;
        fim = valores.length-1;

        while (inicio <= fim){
            meio = (inicio + fim)/2;
            if (val == valores[meio]){
                return meio;
            } else {
                if (val > valores[meio]){
                    inicio = meio+1;
                } else {
                    fim = meio-1;
                }
            }
        }
        return -1;
    }
}
