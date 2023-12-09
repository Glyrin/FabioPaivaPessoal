/*
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
*/
import java.util.Scanner;
import java.util.Locale;

public class ficha04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Exercício 1");
        int num1=1;
        while(num1<=10){
            System.out.print(num1+";");
            num1++;
        }
        System.out.println("\n");

        System.out.println("Exercício 2");
        System.out.print("Escreva um número: ");
        int num2 = input.nextInt();
        int tab=0;
        while(tab<=12){
            System.out.println(num2+" x "+tab+" = "+(num2*tab));
            tab++;
        }
        System.out.print("\n");

        System.out.println("Exercício 3");
        System.out.print("Escreva um número: ");
        int num3 = input.nextInt();
        int original=num3;
        String inv="";
        int dig;
        while(num3>=1){
            dig=num3%10;
            inv=inv+dig;
            num3=num3/10;
        }
        System.out.println("O número inverso de "+original+", é o número "+inv+".\n");

        System.out.println("Exercício 4");
        System.out.print("Escreva um número: ");
        int num4 = input.nextInt();
        int original2=num4;
        int soma=0;
        int resto2;
        while(num4>=1){
            resto2=num4%10;
            soma=soma+resto2;
            num4=num4/10;
        }
        System.out.println("A soma dos algarismos de "+original2+", é "+soma+".\n");

        System.out.println("Exercício 5");
        int num5=101;
        int soma2=0;
        while(num5<=200){
            if(num5%9==0) {
                System.out.println(num5 + " é divisível por 9.");
                soma2=soma2+num5;
            }
            num5++;
        }
        System.out.println("A soma dos múltiplos de 9 entre 101 e 200 é "+soma2+".\n");

        System.out.println("Exercício 6");
        System.out.print("Escreva um número: ");
        int num6 = input.nextInt();
        boolean primo=true;
        if(num6==1){
            primo=false;
        }else if(num6!=2 && num6%2==0){
            primo=false;
        }for(int n=3;n<=(num6/2);n=n+2){
            if(num6%n==0){
                primo=false;
                break;
            }
        }
        if(primo==true){
            System.out.println(num6+" é número primo.\n");
        }else{
            System.out.println(num6+" não é número primo.\n");
        }

        System.out.println("Exercício 7");
        System.out.print("Escreva um número: ");
        int num7 = input.nextInt();
        int ori=num7;
        String inv2="";
        int resto3=0;
        while(num7>=1){
            resto3=num7%10;
            inv2=inv2+resto3;
            num7=num7/10;
        }
        int inverso=Integer.parseInt(inv2);
        if(ori==inverso){
            System.out.println("O número "+ori+", é capicua.\n");
        }else{
            System.out.println("O número "+ori+", não é capicua.\n");
        }

        System.out.println("Exercício 8");
        System.out.print("Quantos números quer elevar ao quadrado? ");
        int num8 = input.nextInt();
        for(int base=1;base<=num8;base++){
            double quad=Math.pow(base,2);
            System.out.print(base+"\u00B2 = "+quad+"; ");
        }
        System.out.println("\n");

        System.out.println("Exercício 9");
        System.out.print("Quantos números ímpares quer somar? ");
        int num9 = input.nextInt();
        int imp=0;
        int soma3=0;
        while(imp<(num9*2)){
            System.out.println(imp);
            if(imp%2!=0){
                soma3 = soma3 + imp;
            }
            imp++;
        }
        System.out.println("A soma dos números ímpares é "+soma3+".\n");

        System.out.println("Exercício 10");
        System.out.print("Fatorial de: ");
        int num10 = input.nextInt();
        int fat=1;
        for(int f=num10;f>=1;f--){
            fat=fat*f;
        }
        System.out.println("O fatorial de ("+num10+"!) é "+fat+".\n");

        System.out.println("Exercício 11");
        /*
        System.out.print("Escreva um nome: ");
        String nome = input.nextLine();
        int tentativas=0;
        int car=nome.length();
        byte[] array = new byte[car];
        String gerado="";
        do {
            new Random().nextBytes(array);
            gerado = new String(array, Charset.forName("UTF-8"));
            tentativas++;
            System.out.println(gerado);
        }while(!nome.equals(gerado));
        System.out.println("Precisei de "+tentativas+" tentativas.\n");
         */

        System.out.print("Digite o nome sem caracteres especiais: ");
        String nome = input.nextLine();
        int tamanho=nome.length();
        String letras="abcdefghijklmnopqrstuvxyz";
        String palpite = "";
        int tentativas = 0;
        while (!palpite.equals(nome)) {
            palpite="";
            for (int pl=0; pl<tamanho; pl++) {
                int indice=(int)(letras.length()*Math.random());
                palpite = palpite+letras.charAt(indice);
            }
            System.out.println("Palpite: " + palpite);
            tentativas++;
        }
        System.out.println("Adivinhei o nome em " + tentativas + " tentativas.\n");

        /*
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();

        String palpite = "";
        int tentativas = 0;

        while(!palpite.equals(nome.toLowerCase())){
            palpite="";
            while(palpite.length()<nome.length()){
                char asciiChar=(char)(Math.random()*26+97);
                palpite=palpite+asciiChar;
            }
            tentativas++;
        }
        System.out.println("Adivinhei o nome em " + tentativas + " tentativas.\n");

        System.out.print("Digite o nome sem caracteres especiais: ");
        String nome = input.nextLine();
        int tamanho=nome.length();

        String palpite = "";
        int tentativas = 0;

        while (!palpite.equals(nome)) {
            palpite = RandomStringUtils.randomAlphabetic(tamanho);
            System.out.println("Palpite: " + palpite);
            tentativas++;
        }

        System.out.println("Adivinhei o nome em " + tentativas + " tentativas.\n");
        */

        System.out.println("Exercício 12");
        System.out.println("Beer Song\n");
        int bottles=99;
        while(bottles>=1){
            System.out.println(
            bottles+" botles of beer on the Wall.\n"+bottles+" botles of beer\nTake one down.\nPass it around.\n");
            bottles--;
        }
        System.out.println("No more bottles of beer on the Wall.\nYou go to the store and buy some more\n99 botles of beer back on the Wall.\n");

        System.out.println("Exercício 13");
        /*
        double areaTotal = 0;
        boolean continuar = true;
        while (continuar) {
            System.out.print("Insira a área de uma divisão da casa: ");
            double areaDivisao = input.nextDouble();
            areaTotal += areaDivisao;

            System.out.print("Tem mais divisões a inserir? (s/n) ");
            String resposta = input.next();
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        System.out.println("A área total da casa é de " + areaTotal + " metros quadrados.\n");
        */
        double areaTotal2 = 0;
        String op;
        do{
            System.out.println("Insira a área de uma divisão da casa: ");
            double areaDivisao2 = input.nextDouble();
            areaTotal2 += areaDivisao2;
            do{
                System.out.println("Tem mais divisões a inserir? (s/n) ");
                op=input.next().toLowerCase();
                if(!op.equals("n") && !op.equals("s")){
                    System.out.println("Opção inválida.");
                }
            }while(!op.equals("n") && !op.equals("s"));
        }while(!op.equals("n"));
        System.out.println("A área total da casa é de " + areaTotal2 + " metros quadrados.\n");

        System.out.println("Exercício 14");
        //


    }
}
