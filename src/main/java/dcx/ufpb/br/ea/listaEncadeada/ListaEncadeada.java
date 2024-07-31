package dcx.ufpb.br.ea.listaEncadeada;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;
    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Elemento inválido";
    private final String LISTA_VAZIA = "Lista vazia";


    public boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public void adiciona(T elemento){
        No<T> celula = new No<>(elemento);
        if (this.tamanho == 0){
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    /**
     * Serve para adicionar no inicio um elemento, caso o tamanho seja igual a 0, o inicio e o ultimo apontam
     * para esse novo nó, pois a lista está vazia. Caso contrário, primeiro criamos um novo nó e passamos para ele
     * o elemento e esse nó ja aponta para o inicio, depois de apontar para o inicio, ai sim colocamos que esse novoNó
     * é o inicio.
     * @param elemento
     */
    public void adicionaInicio (T elemento){
        if (this.tamanho == 0){
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void adiciona (int posicao, T elemento){
        if (this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        } else if (posicao == 0){
            this.adicionaInicio(elemento);
        } else {
            No<T> anteriorNo = this.buscaNo(posicao);
            No<T> proximoNo = anteriorNo.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            anteriorNo.setProximo(novoNo);
            this.tamanho++;
        }
    }


    /**
     * Testa-se se a lista está vazia antes. Caso contrário, salvamos o elemento que está no inicio na variável
     * "removido", colocamos que o inicio se torna o elemento posterior ao que estava antes e assim, decrementamos
     * o tamanho da lista. Caso a lista tivesse apenas 1 elemento, o ultimo continuaria apontando para o elemento,
     * então colocamos que o último fica nulo.
     * @return
     */
    public T removerInicio(){
        if (this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }

        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0){
            this.ultimo = null;
        }

        return removido;
    }


    /**
     * Primeiro, declaramos o penultimo nó como o tamanho -2, pois, digamos que há uma lista: [0, 1, 2], ela tem o tamanho
     * igual a 3, diminuindo 2, fica a posição 1, que é o elemento [1], ou seja, o penultimo. Salvamos esse elemento na
     * variável chamada "removido", pegando o elemento posterior ao penultimo, ou seja, o último. Declaramos o último
     * como nulo, e a posição "último" começa a valer como o penultimo Nó, e então decrementamos o tamanho.
     * @return
     */

    public T removerFinal(){
        if (this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }

        if (this.tamanho == 1){
            return this.removerInicio();
        }

        No<T> penultimoNo = buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }


    /**
     * Determina primeiro os Nós, sendo o anterior, o atual e o proximo ao atual. O próximo do noAnterior se torna o próximo
     * ao nó atual, fazendo com que o nó atual deixe de estar linkado a lista. Após isso, colocamos o próximo do nó atual como
     * nulo, decrementamos o tamanho e retornamos o nó que foi removido.
     * @param posicao
     * @return
     */
    public T removePos (int posicao){
        if (this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        if (posicao == 0){
            return this.removerInicio();
        }

        if (posicao == this.tamanho-1){
            return this.removerFinal();
        }

        No<T> noAnterior = this.buscaNo(posicao - 1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> proximo = noAtual.getProximo();

        noAnterior.setProximo(proximo);
        noAtual.setProximo(null);
        this.tamanho--;

        return noAtual.getElemento();
    }

    public No<T> buscaNo(int posicao){

        if (this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++){
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }

    public T buscaPorPosicao(int posicao){
        return this.buscaNo(posicao).getElemento();
    }

    public int buscaPeloElemento(T elemento){
        No<T> noAtual = this.inicio;
        int pos = 0;

        while (noAtual != null){
            if (noAtual.getElemento().equals(elemento)){
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximo();
        }
        return NAO_ENCONTRADO;

    }

    public void limpa(){

        for (No<T> atual = this.inicio; atual != null;){
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder().append("[");

        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho - 1; i++){
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");


        /**
         * builder.append(atual.getElemento()).append(",");
         * while (atual.getProximo() != null){
         * atual = atual.getProximo();
         * builder.append(atual.getElemento()).append(",");
         */


        return builder.toString();
    }
}
