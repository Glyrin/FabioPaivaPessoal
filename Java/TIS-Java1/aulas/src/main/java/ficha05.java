import java.util.Scanner;

public class ficha05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Exercício 1");
        int[] valores = {4,8,15,16,23,42};
        for (int res:valores) {
            System.out.print(res+"; ");
        }
        System.out.println("\n");

        System.out.println("Exercício 2");
        int[] valores5 = {4,8,15,16,23,42};
        double soma=0;
        for(int b=0;b<valores5.length;b++) {
            soma += valores5[b];
        }
        System.out.println("A soma dos valores no array é "+soma+"\n");

        System.out.println("Exercício 3");
        int[] valores2 = {4,8,15,16,23,42};
        double media=0;
        for(int p=0;p<valores2.length;p++){
            media+=valores2[p];
        }
        media=media/valores2.length;
        System.out.println("A média dos valores no array é "+media+"\n");

        System.out.println("Exercício 4");
        String[] nomes2 = {"Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt"};
        System.out.print("Escreva um nome: ");
        String cond = input.nextLine();
        Boolean verificacao= false;
        for(int c=0;c<nomes2.length;c++) {
            if (nomes2[c].equals(cond)) {
                verificacao = true;
                break;
            }
        }
        if(verificacao){
            System.out.println(cond+" existe no array.\n");
        }else{
            System.out.println(cond+" não existe no array.\n");
        }

        System.out.println("Exercício 5");
        int[] valores3 = {4,8,15,16,23,42};
        System.out.println("Array valores:");
        for (int res:valores3) {
            System.out.print(res+"; ");
        }
        System.out.println();
        int[] copia = {4,8,15,16,23,42};
        System.out.println("Array copia:");
        for (int cop:copia) {
            System.out.print(cop+"; ");
        }
        System.out.println("\n");

        System.out.println("Exercício 6");
        int[] valores6 = {4,8,15,16,23,42};
        System.out.println("Array valores:");
        for (int res:valores6) {
            System.out.print(res+"; ");
        }
        int Maior=valores6[0];
        int menor=valores6[0];
        for(int d=0;d<valores6.length;d++){
            if(valores6[d]<menor){menor=valores6[d];}
            if(valores6[d]>Maior){Maior=valores6[d];}
        }
        System.out.println("\nO maior dos valores é "+Maior+".");
        System.out.println("O menor dos valores é "+menor+".\n");

        System.out.println("Exercício 7");
        int[] valores7 = {4,8,15,16,23,42};
        for(int e=valores7.length-1;e>=0;e--){
            System.out.print(valores7[e]+"; ");
        }
        System.out.println("\n");

        System.out.println("Exercício 8");
        int[] valores4 = {4,8,15,16,23,42};
        System.out.println("\nArray valores:");
        for (int res:valores4) {
            System.out.print(res+"; ");
        }
        int[] inverso = new int[6];
        int i=0;
        for(int p=valores4.length-1;p>=0;p--){
            inverso[i]=valores4[p];
            i++;
        }
        System.out.println("Array inverso:");
        for (int inv:inverso) {
            System.out.print(inv+"; ");
        }
        System.out.println("\n");

        System.out.println("Exercício 9");
        String[] nomes = {"Mike Rack", "Phil Wood", "Moe Lester", "Ben Dover", "Mike Hunt", "Mike Rack", "Phil Wood"};
        for (String nome : nomes) {
            System.out.print(nome+"; ");
        }
        System.out.println("\nDuplicados:");
        for (int p = 0; p < nomes.length; p++) {
            for (int a = p + 1; a < nomes.length; a++) {
                if (nomes[p] == nomes[a] && (p!=a)) {
                    System.out.println(nomes[a] + " aparece esté duplicado no array.");
                }
            }
        }
        System.out.println();

        System.out.println("Exercício 10");
        String[] nome3 = {"Mike Rack","Phil Wood","Moe Lester","Ben Dover","Mike Hunt"};
        String[] nome4 = {"Mike Rack","Chris P. Bacon","Dixon Payne","Ben Dover","Krystal Ball"};
        System.out.println("Array 1:");
        for (String nome:nome3) {
            System.out.print(nome+"; ");
        }
        System.out.println();
        System.out.println("Array 2:");
        for (String nome:nome4) {
            System.out.print(nome+"; ");
        }
        System.out.println();
        for (int f=0;f<nome3.length;f++){
            for(int g=0;g<nome4.length;g++){
                if(nome3[f]==nome4[g]){
                    System.out.println(nome3[f]+" existe nos 2 arrays.");
                }
            }
        }
        System.out.println();

        System.out.println("Exercício 11");
        String[] texto1 = {"O","Um","Aquele","Algum"};
        String[] texto2 = {"Chico","Zé","cão","Joãozinho"};
        String[] texto3 = {"sabe a resposta","se nicou","foi apanhado","está maluco"};
        int rand1 = (int)(Math.random() * texto1.length);
        int rand2 = (int)(Math.random() * texto2.length);
        int rand3 = (int)(Math.random() * texto3.length);
        String palavra1=texto1[rand1];
        String palavra2=texto2[rand2];
        String palavra3=texto3[rand3];
        System.out.println(palavra1+" "+palavra2+" "+palavra3+"\n");

        System.out.println("Exercício 12");
        int[] valores11 = {4,8,15,16,23,42};
        int[] valores12 = {4,8,15,16,23,42};
        int[] soma2 = new int[6];
        System.out.println("Array 1");
        for (int res:valores11) {
            System.out.print(res+"; ");
        }
        System.out.println("\nArray 2");
        for (int res:valores12) {
            System.out.print(res+"; ");
        }
        for(int h=0;h<valores11.length;h++){
            soma2[h]=valores11[h]+valores12[h];
        }
        System.out.println("\nArray Soma");
        for (int res:soma2) {
            System.out.print(res+"; ");
        }
    }
}
