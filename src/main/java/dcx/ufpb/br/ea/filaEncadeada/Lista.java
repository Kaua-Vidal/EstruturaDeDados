package dcx.ufpb.br.ea.filaEncadeada;

public class Lista {

    private Caixinha inicio;

    public Lista(){
        this.inicio = null;
    }

    public void inserir(int elemento){
        Caixinha nova = new Caixinha();
        nova.setElemento(elemento);
        nova.setProximo(null);

        if (inicio == null){    //para ver se a caixinha está vazia
            inicio = nova;
        } else {
            Caixinha aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nova);
        }

    }
    public int retirar (){

        if (inicio == null){
            throw new RuntimeException("A lista está vazia");
        }

        Caixinha aux = inicio;
        int elemento = aux.getElemento();
        inicio = aux.getProximo();
        return elemento;

    }
    public void listar(){
        if (inicio == null){
            System.out.println("A lista está vazia");
        } else {
            Caixinha aux = inicio;
            while (aux != null){
                System.out.println("Elemento visto: "+aux.getElemento());
                aux = aux.getProximo();
            }
        }

    }
    public boolean isEmpty(){
        return this.inicio == null;
    }
}
