import java.util.Scanner;
import java.util.Locale;
public class aula06 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Olá");
        metodo1();
        String cumprimento=metodo2();
        cumprimento=cumprimento+"!";
        System.out.println(cumprimento);
        System.out.println(metodo2()+"?");
        System.out.println(metodo3(3,4));
        System.out.println(metodo4(3,4));
        System.out.println(metodo3(3.0,4.0));
    }
    // método void, não devolve nada para fora, fica tudo contido lá dentro
    public static void metodo1(){
        System.out.println("Olá do método 1");
    }
    // método String, devolve texto, pode ser alterado no método main
    public static String metodo2(){
        return "Olá do método 2";
    }
    // método int, devolve números inteiros
    public static int metodo3(int num1,int num2) {
        // int res=num1+num2;
        // return res;
        return num1+num2; // devolve a mesma coisa
    }
    public static double metodo3(double num1,double num2) {
        return num1+num2; // devolve igual ao anterior mas como double e não int
    }
    public static boolean metodo4(int num1,int num2) {
        return num1>num2;
    }
    public static String[] metodo5(){
        String[] cenas={"José", "Carlos"};
        return cenas;
    }
}
