package dcx.ufpb.br.ea.buscaSequenciada;

public class BuscaBinariaESequencial {
    public static void main(String[] args){
        Colecao colecao = new Colecao();
        System.out.println("-----------------------Busca Sequenciada---------------------");
        System.out.println("Posiçao do elemento 12: "+colecao.BuscaSequenciada(12));
        System.out.println("Posiçao do elemento 23: "+colecao.BuscaSequenciada(23));
        System.out.println("Posiçao do elemento 24: "+colecao.BuscaSequenciada(24));
        System.out.println("Posiçao do elemento 99: "+colecao.BuscaSequenciada(99));
        System.out.println("\n\n");
        System.out.println("-----------------------Busca Binaria---------------------");
        System.out.println("Posiçao do elemento 12: "+colecao.BuscaBinaria(12));
        System.out.println("Posiçao do elemento 23: "+colecao.BuscaBinaria(23));
        System.out.println("Posiçao do elemento 24: "+colecao.BuscaBinaria(24));
        System.out.println("Posiçao do elemento 99: "+colecao.BuscaBinaria(99));
    }
}
