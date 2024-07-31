package dcx.ufpb.br.ea.filaDuplamenteEncadeada;

public class ListaDuplaCircular {

    private CaixinhaDupla inicio;

    public ListaDuplaCircular(){
        this.inicio = null;
    }

    public boolean isEmpty(){
        return (this.inicio == null);
    }

    public void inserir (int elemento){
        CaixinhaDupla novo = new CaixinhaDupla();
        novo.setElemento(elemento);

        if (isEmpty()){
            novo.setAnterior(novo);
            novo.setProximo(novo);
            inicio = novo;
        } else {
            CaixinhaDupla tmp = inicio;
            while (tmp.getProximo() != inicio){
                tmp = tmp.getProximo();
            }
            tmp.setProximo(novo);
            novo.setProximo(tmp);
            novo.setProximo(inicio);
        }

    }
}
