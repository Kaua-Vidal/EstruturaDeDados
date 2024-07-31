package dcx.ufpb.br.ea.filaDuplamenteEncadeada;

public class CaixinhaDupla {
    private int elemento;
    private CaixinhaDupla proximo;
    private CaixinhaDupla anterior;

    public void setElemento(int elemento){
        this.elemento = elemento;
    }
    public void setProximo (CaixinhaDupla proximo){
        this.proximo = proximo;
    }
    public void setAnterior (CaixinhaDupla anterior){
        this.anterior = anterior;
    }
    public int getElemento(){
        return this.elemento;
    }
    public CaixinhaDupla getProximo(){
        return this.proximo;
    }
    public CaixinhaDupla getAnterior(){
        return this.anterior;
    }
}
