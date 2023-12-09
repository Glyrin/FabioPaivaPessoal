import java.util.Scanner;
import java.util.Locale;

public class aula05 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in).useLocale(Locale.US);

        String[] nome; // inicia vazio e na primeira utilização define o tamanho
        int[] idades=new int[4]; // inicia logo com espaço para 4 valores
        String[] nomes={"João", "Joaquim", "Zé", "Renato"}; // iniciou vazio mas os elementos limitou a 4

        System.out.println(nomes[2]);
        System.out.println(idades[2]);

        nomes[2]="António";
        idades[2]=37;

        System.out.println(nomes[2]);
        System.out.println(idades[2]);
        System.out.println(nomes.length);
        System.out.println(idades.length);

        for(int i=0;i<nomes.length;i++){
            System.out.println(nomes[i]);
        }
        for(int i=idades.length-1;i>=0;i--){
            System.out.println(idades[i]);
        }
        // foreach, bom para imprimir só resultados
        for (String nome1:nomes) {
            System.out.println(nome1);
        }

    }
}
