package dcx.ufpb.br.ea.pilhaDinamica;

public class Pilha implements IPilha {
    private int valores[];
    private int topo;

    public Pilha(){
        valores = new int[10];
        topo = -1;
    }

    public void push(int elemento){
        topo++;
        valores[topo] = elemento;
    }
    public int pop(){
        int e = valores[topo];
        topo--;
        return e;
    }
    public boolean isEmpty(){
        return (topo == -1);
    }
}
