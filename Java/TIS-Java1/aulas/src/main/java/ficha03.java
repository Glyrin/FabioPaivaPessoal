import java.util.Scanner;
import java.util.Locale;

public class ficha03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Exercício 1");
        System.out.print("Escreva um número: ");
        double n1 = input.nextDouble();
        System.out.print("Escreva outro número: ");
        double n2 = input.nextDouble();
        if (n1 == n2) {
            System.out.println("os números não iguais.\n");
        } else {
            System.out.println("Os números são diferentes.\n");
        }

        System.out.println("Exercício 2");
        System.out.print("Escreva um número: ");
        double num1 = input.nextDouble();
        if (num1 == 0) {
            System.out.println("O número " + num1 + " é zero.\n");
        } else if (num1 > 0) {
            System.out.println("O número " + num1 + " é positivo.\n");
        } else {
            System.out.println("O número " + num1 + " é negativo.\n");
        }

        System.out.println("Exercício 3");
        System.out.print("Digite o primeiro número: ");
        int n3 = input.nextInt();
        System.out.print("Digite o segundo número: ");
        int n4 = input.nextInt();
        System.out.print("Digite o terceiro número: ");
        int n5 = input.nextInt();
        int M = n3;
        if (n4 > n3) {
            M = n4;
        }
        if (n5 > n4) {
            M = n5;
        }
        System.out.println("Maior número entre (" + n3 + ", " + n4 + ", " + n5 + ") é " + M + ".\n");

        System.out.println("Exercício 4");
        System.out.print("Digite o primeiro número: ");
        int num2 = input.nextInt();
        System.out.print("Digite o segundo número: ");
        int num3 = input.nextInt();
        if (num2 % num3 == 0) {
            System.out.println("o número " + num2 + " é multiplo de " + num3 + ".\n");
        } else {
            System.out.println("o número " + num2 + " não é multiplo de " + num3 + ".\n");
        }

        System.out.println("Exercício 5");
        System.out.print("Digite um número: ");
        int n6 = input.nextInt();
        if (n6 == 0) {
            System.out.println("Nem é par nem ímpar é zero.\n");
        } else if (n6 % 2 == 0) {
            System.out.println("O número " + n6 + " é par.\n");
        } else {
            System.out.println("O número " + n6 + " é ímpar.\n");
        }

        System.out.println("Exercício 6");
        System.out.print("Digite a sua altura em metros: ");
        double alt = input.nextDouble();
        if (alt < 0.24) {
            System.out.println("Uma pessoa com " + alt + "m de altura é baixíssima.");
            System.out.println("Novo recorde do Guiness. A pessoa mais pequena à nascença tinha 24 centímetros.\n");
        } else if (alt < 1.30) {
            System.out.println("Uma pessoa com " + alt + "m de altura é baixíssima.\n");
        } else if (alt < 1.60) {
            System.out.println("Uma pessoa com " + alt + "m de altura é baixa.\n");
        } else if (alt < 1.75) {
            System.out.println("Uma pessoa com " + alt + "m de altura é mediana.\n");
        } else if (alt < 1.90) {
            System.out.println("Uma pessoa com " + alt + "m de altura é alta.\n");
        } else if (alt < 2.75) {
            System.out.println("Uma pessoa com " + alt + "m de altura é altíssima.\n");
        } else {
            System.out.println("Uma pessoa com " + alt + "m de altura é altíssima.");
            System.out.println("Novo recorde do Guiness. A pessoa mais mais alta do mundo tinha 2,74m de altura.\n");
        }

        System.out.println("Exercício 7");
        System.out.print("Insira o primeiro operando: ");
        double n7 = input.nextDouble();
        System.out.print("Insira o segundo operando: ");
        double n8 = input.nextDouble();
        System.out.print("Insira a operação: ");
        String op = input.next();
        switch (op) {
            case "+":
                System.out.println("A soma de " + n7 + " com " + n8 + ", é " + (n7 + n8) + ".\n");
            case "-":
                System.out.println("A subtração de " + n8 + " a " + n7 + ", é " + (n7 - n8) + ".\n");
            case "*":
                System.out.println("A multiplicação de " + n7 + " com " + n8 + ", é " + (n7 * n8) + ".\n");
            case "/":
                System.out.println("A divisão de " + n7 + " por " + n8 + ", é " + (n7 / n8) + ".\n");
            default:
                System.out.println("Usa o operador correto.\n");
        }

        System.out.println("Exercício 8");
        System.out.print("Insira a coordenada X: ");
        double x=input.nextDouble();
        System.out.print("Insira a coordenada Y: ");
        double y=input.nextDouble();
        if(x==0 && y==0){
            System.out.println("Está na origem.\n");
        }else if(x>0 && y>0){
            System.out.println("Está no primeiro quadrante.\n");
        }else if(x<0 && y>0){
            System.out.println("Está no segundo quadrante.\n");
        }else if(x<0 && y<0){
            System.out.println("Está no terceiro quadrante.\n");
        }else if(x>0 && y<0){
            System.out.println("Está no quarto quadrante.\n");
        }else{
            System.out.println("está em cima de um dos eixos.\n");
        }

        System.out.println("Exercício 9");
        System.out.print("Digite o primeiro número: ");
        int n11=input.nextInt();
        System.out.print("Digite o segundo número: ");
        int n12=input.nextInt();
        System.out.print("Digite o terceiro número: ");
        int n13=input.nextInt();
        System.out.print("Ordem ascesdente entre ("+n11+", "+n12+", "+n13+") é: ");
        if(n11==n12 || n11==n13 || n12==n13){
            System.out.print("Existem números iguais.\n");
        }else if(n11<n12 && n11<n13){
            if(n12<n13){
                System.out.print(n11+" < "+n12+" < "+n13+"\n");
            }else{
                System.out.print(n11+" < "+n13+" < "+n12+"\n");
            }
        }else if(n12<n13){
            if(n11<n13){
                System.out.print(n12+" < "+n11+" < "+n13+"\n");
            }else{
                System.out.print(n12+" < "+n13+" < "+n11+"\n");
            }
        }else{
            if(n11<n12){
                System.out.print(n13+" < "+n11+" < "+n12+"\n");
            }else{
                System.out.print(n13+" < "+n12+" < "+n11+"\n");
            }
        }

        System.out.println("Exercício 10");
        System.out.print("Insira um número entre 1 e 999: ");
        int num4=input.nextInt();
        if (num4<1 || num4>999){
            System.out.println("Eu disse entre 1 e 999.\n");
        }else {
            int uni = num4 % 10;
            int resto = num4 / 10;
            int dez = resto % 10;
            resto = resto / 10;
            int cent = resto % 10;
            String u = "";
            String d = "";
            String c = "";
            switch (uni) {
                case 0:
                    u = "";
                    break;
                case 1:
                    u = "I";
                    break;
                case 2:
                    u = "II";
                    break;
                case 3:
                    u = "III";
                    break;
                case 4:
                    u = "IV";
                    break;
                case 5:
                    u = "V";
                    break;
                case 6:
                    u = "VI";
                    break;
                case 7:
                    u = "VII";
                    break;
                case 8:
                    u = "VIII";
                    break;
                case 9:
                    u = "IX";
                    break;
            }
            switch (dez) {
                case 0:
                    d = "";
                    break;
                case 1:
                    d = "X";
                    break;
                case 2:
                    d = "XX";
                    break;
                case 3:
                    d = "XXX";
                    break;
                case 4:
                    d = "XL";
                    break;
                case 5:
                    d = "L";
                    break;
                case 6:
                    d = "LX";
                    break;
                case 7:
                    d = "LXX";
                    break;
                case 8:
                    d = "LXXX";
                    break;
                case 9:
                    d = "XC";
                    break;
            }
            switch (cent) {
                case 0:
                    c = "";
                    break;
                case 1:
                    c = "C";
                    break;
                case 2:
                    c = "CC";
                    break;
                case 3:
                    c = "CCC";
                    break;
                case 4:
                    c = "CD";
                    break;
                case 5:
                    c = "D";
                    break;
                case 6:
                    c = "DC";
                    break;
                case 7:
                    c = "DCC";
                    break;
                case 8:
                    c = "DCCC";
                    break;
                case 9:
                    c = "CM";
                    break;
            }
            System.out.println(num4 + " em numeração romana é " + c + d + u + ".\n");
        }

        System.out.println("Exercício 11");
        System.out.print("Insira a nota do 1º teste: ");
        double te1=input.nextDouble();
        System.out.print("Insira a nota do 2º teste: ");
        double te2=input.nextDouble();
        System.out.print("Insira a nota do 1º trabalho: ");
        double ta1=input.nextDouble();
        System.out.print("Insira a nota do 2º trabalho: ");
        double ta2=input.nextDouble();
        System.out.print("Insira a nota do trabalho final: ");
        double tf=input.nextDouble();
        double p1=0.65;
        double p2=0.15;
        double p3=0.2;
        double NF=(p1*(te1+te2))/2+(p2*(ta1+ta2))/2+(p3*tf);
        if(NF<9.5){
            System.out.println("A nota final do aluno foi "+Math.round(NF)+". O aluno foi reprovado.\n");
        }else{
            System.out.println("A nota final do aluno foi "+Math.round(NF)+". O aluno foi aprovado.\n");
        }

        System.out.println("Exercício 12");
        System.out.print("Insira um ano para saber se é bissexto: ");
        int ano=input.nextInt();
        if ((ano%4==0 && ano%100!=0) || ano%400==0){
            System.out.println("O ano "+ano+" é um ano bissexto.\n");
        }else{
            System.out.println("O ano "+ano+" é um ano comum.\n");
        }

        System.out.println("Exercício 13");
        System.out.print("Insira o coeficiente a da função quadrática: ");
        int a=input.nextInt();
        System.out.print("Insira o coeficiente b da função quadrática: ");
        int b=input.nextInt();
        System.out.print("Insira o coeficiente c da função quadrática: ");
        int c=input.nextInt();
        double d=Math.pow(b,2)-(4*a*c);
        if (d>0){
            System.out.println("As raízes são reais e diferentes");
            double r1=(-b+Math.sqrt(d))/(2*a);
            double r2=(-b-Math.sqrt(d))/(2*a);
            System.out.println("As raízes são "+r1+" e "+r2+".\n");
        }else if(d==0){
            System.out.println("As raízes são reais e iguais");
            double r3=(-b)/(2*a);
            System.out.println("Ambas as raízes são "+r3+".\n");
        }else{
            System.out.println("As raízes são complexas e diferentes");
            String r4=((-b)/(2*a))+"+ i \u221A("+d+")/"+(2*a);
            String r5=((-b)/(2*a))+"- i \u221A("+d+")/"+(2*a);
            System.out.println("As raízes são "+r4+" e "+r5+".\n");
        }
    }
}
