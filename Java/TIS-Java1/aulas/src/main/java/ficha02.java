import java.util.Scanner;
import java.util.Locale;

public class ficha02 {

    public static void main(String[] args){
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Exercício 1");
        System.out.print("Escreva um nome: ");
        String nome=input.nextLine();
        System.out.println("Olá "+nome+".\n");

        System.out.println("Exercício 2");
        System.out.print("Escreva um número: ");
        int num1=input.nextInt();
        System.out.print("Escreva outro número: ");
        int num2=input.nextInt();
        System.out.println("Soma dos números: "+(num1+num2)+"\n");

        System.out.println("Exercício 3");
        System.out.print("Escreva um número: ");
        int num6=input.nextInt();
        System.out.print("Escreva outro número: ");
        int num7=input.nextInt();
        System.out.println("Divisão dos números: "+(double)num6/num7+"\n");

        System.out.println("Exercício 4");
        System.out.print("Escreva um número: ");
        int num3=input.nextInt();
        System.out.print("Escreva outro número: ");
        int num4=input.nextInt();
        System.out.println("Produto dos números: "+(num3*num4)+"\n");

        System.out.println("Exercício 5");
        System.out.print("Escreva um número: ");
        int num8=input.nextInt();
        System.out.print("Escreva outro número: ");
        int num9=input.nextInt();
        System.out.println("Soma dos números: "+(num8+num9));
        System.out.println("Subtração dos números: "+(num8-num9));
        System.out.println("Produto dos números: "+(num8*num9));
        System.out.println("Divisão dos números: "+(double)num8/num9+" com "+(num8%num9)+" como resto da divisão.\n");

        System.out.println("Exercício 6");
        System.out.print("Escreva o raio da circunferência: ");
        double raio=input.nextDouble();
        final double PI=3.14;
        double diametro=2*raio;
        double area=Math.pow(raio,2)*PI;
        double perimetro=2*raio*PI;
        System.out.println("Diâmetro: "+diametro);
        System.out.println("Área: "+area);
        System.out.println("Perímetro: "+perimetro+"\n");

        System.out.println("Exercício 7");
        System.out.print("Escreva o 1º número: ");
        int n1=input.nextInt();
        System.out.print("Escreva o 2º número: ");
        int n2=input.nextInt();
        System.out.print("Escreva o 3º número: ");
        int n3=input.nextInt();
        System.out.print("Escreva o 4º número: ");
        int n4=input.nextInt();
        System.out.print("Escreva o 5º número: ");
        int n5=input.nextInt();
        int soma=n1+n2+n3+n4+n5;
        System.out.println("soma dos números: "+soma);
        System.out.println("Média: "+(double)soma/5+"\n");

        System.out.println("Exercício 8");
        System.out.print("Escreva a largura: ");
        int largura=input.nextInt();
        System.out.print("Escreva comprimento: ");
        int comprimento=input.nextInt();
        int area2=largura*comprimento;
        int perimetro2=2*largura+2*comprimento;
        System.out.println("Área: "+area2);
        System.out.println("Perímetro: "+perimetro2+"\n");

        System.out.println("Exercício 9");
        System.out.print("Escreva a temperatura em Celsius: ");
        double c=input.nextDouble();
        double f=(c*1.8)+32;
        System.out.println(c+"ºC equivale a "+f+"ºF.\n");

        System.out.println("Exercício 10");
        System.out.print("Escreva a temperatura em Fahrenheit: ");
        double far=input.nextDouble();
        double cel=(far-32)*(5.0/9.0);
        System.out.println(far+"ºF equivale a "+cel+"ºC.\n");

        System.out.println("Exercício 11");
        System.out.print("Escreva o número entre 0 e 1000: ");
        int n6=input.nextInt();
        if (n6<0 || n6>1000){
            System.out.println("Eu disse entre o e 1000, LERDO.\n");
        }else{
            int orig=n6;
            int soma2=0;
            while(n6>=1){
                int resto2=n6%10;
                soma2=soma2+resto2;
                n6=n6/10;
            }
            System.out.println("A soma dos dígitos de "+orig+", é "+soma2+".\n");
        }

        System.out.println("Exercício 12");
        System.out.print("Escreva o número de minutos: ");
        int min=input.nextInt();
        int anos=min/518400;
        int dias=min/1440;
        System.out.println(min+" minutos equivale a "+anos+" anos e a "+dias+" dias.\n");

        System.out.println("Exercício 13");
        System.out.print("Escreva um número: ");
        int n7=input.nextInt();
        System.out.print("Escreva outro número: ");
        int n8=input.nextInt();
        System.out.println("Soma dos números: "+(n7+n8));
        System.out.println("Subtração dos números: "+(n7-n8));
        System.out.println("Produto dos números: "+(n7*n8));
        System.out.println("Divisão dos números: "+(double)n7/n8);
        System.out.println("Média dos números: "+(double)(n7+n8)/2+"\n");

        System.out.println("Exercício 14");
        System.out.print("Escreva o número não inteiro: ");
        double num5=input.nextDouble();
        int arr=(int)Math.round(num5);
        /* Prof não quer que se use if nestes exercícios
        int p1;
        int p2;
            if (arr%2==0){
                p1=arr-2;
                p2=arr+2;
            }else{
                p1=arr-1;
                p2=arr+1;
            }
        */
        int p1=(arr-2)+(arr%2);
        int p2=(arr+2)-(arr%2);
        System.out.print(num5+" arredonda para "+arr+" o número par anterior é "+p1+" e o numero par seguinte é "+p2+".\n");

        System.out.println("Exercício 15");
        System.out.print("Escreva os segundos a converter: ");
        int seg=input.nextInt();
        int dia=seg/86400;
        int horas=(seg%86400)/3600;
        int minutos=((seg%86400)%3600)/60;
        int segundos=((seg%86400)%3600)%60;
        System.out.println(seg+"segundos equivalem a "+dia+" dias, "+horas+" horas, "+minutos+" minutos e "+segundos+"segundos.");
    }
}
