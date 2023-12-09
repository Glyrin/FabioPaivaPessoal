import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Locale;

public class ficha06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Exercício 1");
        System.out.print("Escreva 3 números inteiros separados por espaços: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        System.out.println(metodo1(num1, num2, num3) + " é o menor dos 3 números.\n");

        System.out.println("Exercício 2");
        System.out.print("Escreva 3 números inteiros separados por espaços: ");
        int num4 = input.nextInt();
        int num5 = input.nextInt();
        int num6 = input.nextInt();
        System.out.println("A média dos 3 números é " + metodo2(num4, num5, num6) + ".\n");

        System.out.println("Exercício 3");
        input.nextLine();
        System.out.print("Escreva uma string ");
        String texto1 = input.nextLine();
        System.out.println(metodo3(texto1));

        System.out.println("Exercício 4");
        System.out.print("Escreva uma string ");
        String texto2 = input.nextLine();
        System.out.println("A string tem " + metodo4(texto2) + " vogais.\n");

        System.out.println("Exercício 5");
        System.out.print("Escreva uma string ");
        String texto3 = input.nextLine();
        System.out.println("A string tem " + metodo5(texto3) + " palavras.\n");

        System.out.println("Exercício 6");
        System.out.print("Escreva um número inteiro: ");
        int num7 = input.nextInt();
        System.out.println("A soma dos dígitos de " + num7 + " é " + metodo6(num7) + ".\n");

        System.out.println("Exercício 7");
        System.out.print("Escreva um ano: ");
        int ano = input.nextInt();
        System.out.println(metodo7(ano) + ".\n");

        System.out.println("Exercício 8");
        //input.nextLine();
        System.out.print("Escreva uma palavra-passe ");
        String texto4 = input.nextLine();
        System.out.println(metodo8(texto4) + ".\n");

        System.out.println("Exercício 9");
        System.out.print("Escreva a base do triângulo: ");
        double base = input.nextDouble();
        System.out.print("Escreva a altura do triângulo: ");
        double altura = input.nextDouble();
        System.out.println("A área do triàngulo é " + metodo9(base, altura) + ".\n");

        System.out.println("Exercício 10");
        System.out.print("Escreva a apótema do pentágono: ");
        double apotema = input.nextDouble();
        System.out.print("Escreva o lado do pentagono: ");
        double lado = input.nextDouble();
        System.out.println("A área do pentágono é " + metodo10(apotema, lado) + ".\n");

        System.out.println("Exercício 11");
        System.out.println("Números twin prime menores que 100:");
        for (int i = 3; i < 97; i++) {
            if (metodo11(i) && metodo11(i + 2)) {
                System.out.print("("+i+" - "+(i+2)+") ");
            }
        }
        System.out.println("\n");

        System.out.println("Exercício 12");
        System.out.print("Insira o valor a investir:");
        double investimento=input.nextDouble();
        System.out.print("Insira a taxa de juro anual:");
        double taxa=input.nextDouble()/100;
        System.out.print("Por quantos anos manterá o investimento:");
        int anos = input.nextInt();
        System.out.println("O retorno do seu investimento é "+metodo12(investimento,taxa,anos)+".\n");
    }

    public static int metodo1(int n1, int n2, int n3) {
        int menor=n1;
        if (n2<menor){menor=n2;}
        if (n3<menor){menor=n3;}
        return menor;
    }
    public static int metodo2(int n1, int n2, int n3) {
        int media=(n1+n2+n3)/3;
        return media;
    }
    public static String metodo3(String texto) {
        texto=texto.trim();
        int tamanho=texto.length();
        if(tamanho%2==0){
            return "Os caractéres centrais são: "+texto.substring(tamanho/2-1,tamanho/2+1)+".\n";
        }else{
            return "O caractere central é: "+texto.substring(tamanho/2,tamanho/2+1)+".\n";
        }
    }
    public static int metodo4(String t) {
        t=t.trim();
        int tamanho=t.length();
        int contagemVogais=0;
        for (int i=0;i<tamanho;i++){
            char letra = t.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A' ||
                letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' || letra == 'á' || letra == 'é' ||
                letra == 'í' || letra == 'ó' || letra == 'ú' || letra == 'Á' || letra == 'É' || letra == 'Í' ||
                letra == 'Ó' || letra == 'Ú' || letra == 'à' || letra == 'ã' || letra == 'õ' || letra == 'â' ||
                letra == 'ê' || letra == 'À' || letra == 'Ã' || letra == 'Õ' || letra == 'Â' || letra == 'Ê' ||
                letra == 'ô' || letra == 'Ô') {
                contagemVogais+=1;
            }
        }
        return contagemVogais;
    }
    public static int metodo5(String t) {
        t = t.trim();
        int contagemPalavras = 1;
        for (int i = 0; i < t.length(); i++) {
            char letra = t.charAt(i);
            if (letra == ' ') {
                contagemPalavras += 1;
            }
        }
        return contagemPalavras;
    }
    public static int metodo6(int n1) {
        int num=n1;
        int soma=0;
        while(num>=1){
            int resto=num%10;
            soma+=resto;
            num=num/10;
        }
        return soma;
    }
    public static String metodo7(int ano) {
        if ((ano%4==0 && ano%100!=0) || ano%400==0){
            return ("O ano "+ano+" é um ano bissexto.\n");
        }else{
            return ("O ano "+ano+" é um ano comum.\n");
        }
    }

    public static String metodo8(String pass) {
        pass=pass.trim();
        int tamanhoPass=pass.length();
        if(tamanhoPass<8){
            return "A senha tem de ter pelo menos 8 caracteres";
        } else if (!pass.matches("[a-zA-Z0-9]+")) {
            return "A senha só pode conter letras e números, por favor também não utilize caracteres acentuados ou especiais.";
        }else{
            int contagemNumeros=0;
            for(int i=0; i<tamanhoPass;i++){
                char c=pass.charAt(i);
                if(Character.isDigit(c)){
                    contagemNumeros++;
                }
            }
            if(contagemNumeros<2){
                return "A senha tem de ter pelo menos 2 números";
            }else{
                return "Palavra-passe é válida";
            }
        }
    }

    public static double metodo9(double base,double altura){
        double area=base*altura/2;
        return area;
    }

    public static double metodo10(double apotema,double lado){
        double area=lado*apotema*5/2;
        return area;
    }

    private static boolean metodo11(int num) {
        boolean primo=true;
        if(num==1){
            primo=false;
        }else if(num!=2 && num%2==0){
            primo=false;
        }for(int n=3;n<=(num/2);n=n+2){
            if(num%n==0){
                primo=false;
                break;
            }
        }
        return primo;
    }

    public static String metodo12(double investimento,double taxa, int anos){
        double retorno=investimento*Math.pow((1+(taxa/12)),(anos*12));
        DecimalFormat df = new DecimalFormat("#.##");
        String retornado = df.format(retorno);
        return retornado;
    }
}
