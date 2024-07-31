package dcx.ufpb.br.ea.listaEncadeada;

public class TesteListaEncadeada {

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());
    }
}
