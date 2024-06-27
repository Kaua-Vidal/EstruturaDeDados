package dcx.ufpb.br.ea.pilhas;

public class PilhaBinario {
    public static void main(String[] args){
        int numero = 172;
        PilhaTeste p = new PilhaTeste();

        int resto;

        while(numero!=0){
            resto = numero%2;
            p.push(resto);
            numero = numero/2;
        }

        while (!p.isEmpty()){
            resto = p.pop();
            System.out.print(resto);
        }
        System.out.println("\nFim do programa");
    }

}
