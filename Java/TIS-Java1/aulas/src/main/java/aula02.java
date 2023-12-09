import java.util.Scanner;

public class aula02 {

    /* bloco de comentário */

    public static void main(String[] args){
        String meuTexto="A minha string";

        System.out.println(meuTexto);
        System.out.println(meuTexto.length()); // conta o número de caracteres, começa em um
        System.out.println(meuTexto.toLowerCase());
        System.out.println(meuTexto.toUpperCase());
        System.out.println(meuTexto.indexOf("h")); // conta a posição, começa a contar do zero
        System.out.println(meuTexto.indexOf("n")); // se o caractére for repetido só mostra o primeiro
        System.out.println(meuTexto.lastIndexOf("n")); // mostra a última ocorrência do caractére

    //concatenar
        System.out.println(meuTexto+"!");
        System.out.println(meuTexto.concat("!"));

    // para tratar caractéres especiais como tal pode ser preciso usar \ antes do caractére
        System.out.println("Olá \"grande\" João");
        System.out.println("Olá \'grande\' João");
        System.out.println("Olá \\grande\\ João");

    // \n faz quebra de linha
        System.out.print("Olá \"grande\" João\n");

    // \t faz tab
        System.out.println("\tOlá \"grande\" João");

    // pedir dados ao utilizador
        Scanner input=new Scanner(System.in);
        // cria no início import java.util.Scanner; e fica à espera dos dados a serem introduzidos

        System.out.print("Indroduza o seu nome: ");
        String nome=input.nextLine();
        // método next() só vai buscar até ao primeiro espaço
        // método nextLine() vai buscar a linha toda
        System.out.println(nome);

        System.out.print("Indroduza a idade: ");
        int num=input.nextInt();
        System.out.println(num);
    }
}
