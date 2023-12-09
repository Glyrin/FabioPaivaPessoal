public class ficha01 {
    public static void main(String[] args){
        System.out.println("Exercício 1");
        System.out.println("Olá");
        System.out.println("Fábio");
        System.out.println(" ");

        System.out.println("Exercício 2");
        System.out.println("Primeiro número é 6");
        int num1=6;
        System.out.println("Segundo número é 9");
        int num2=9;
        System.out.println("A soma é "+(num1+num2));
        System.out.println(" ");

        System.out.println("Exercício 3");
        System.out.println("Primeiro número é 20");
        int num3=20;
        System.out.println("Segundo número é 4");
        int num4=4;
        System.out.println("A divisão é "+(num3/num4));
        System.out.println(" ");

        System.out.println("Exercício 4");
        double a, b, c, d;
        a=-5+8*6;
        b=(55+9)%9;
        c=20+(-3)*5/8;
        d=5+15/3*2-8%3;
        System.out.println("a. "+a);
        System.out.println("b. "+b);
        System.out.println("c. "+c);
        System.out.println("d. "+d);
        System.out.println(" ");

        System.out.println("Exercício 5");
        System.out.println("Expressão = ((25.5*3.5-3.5*3.5)/(40.5-4.5))");
        double expressao=((25.5*3.5-3.5*3.5)/(40.5-4.5));
        System.out.println("Resultado da expressão = "+expressao);
        System.out.println(" ");

        System.out.println("Exercício 6");
        int v1=4;
        System.out.println("Variável 1 = "+v1);
        int v2=20;
        System.out.println("Variável 2 = "+v2);
        int v3=v1;
        v1=v2;
        v2=v3;
        System.out.println("Variável 1 depois da troca = "+v1);
        System.out.println("Variável 2 depois da troca = "+v2);
        System.out.println(" ");

        System.out.println("Exercício 7");
        int v4=4;
        System.out.println("Variável 1 = "+v4);
        int v5=20;
        System.out.println("Variável 2 = "+v5);
        v4=v4+v5;
        v5=v4-v5;
        v4=v4-v5;
        System.out.println("Variável 1 depois da troca = "+v4);
        System.out.println("Variável 2 depois da troca = "+v5);
    }
}
