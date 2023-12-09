public class aula01 {
    // comentário

    /* bloco de comentário */

    /*
        STACK - Só Dados Primitivos
        byte - 8 bits
        short - 16 bits
        int - 32 bits (por defeito para números inteiros)
        long - 64 bits
        float - 32 bits
        double - 64 bits (por defeito para números décimais)
        boolean - true / false
        char - só um caractére, limitados por plicas ' '

        HEAP - Não Primitivos
        String - Conjunto de caractéres, limitados por aspas " "
        ...
     */
    public static void main(String[] args){
        //System.out.print() imprime a linha
        //System.out.println() imprime e passa para a linha seguinte
        System.out.println("Olá mundo!"); //imprimir texto
        System.out.println(3+5); // imprimir números ou contas

        int num1; // declarar sem valor
        int num2=19; // declarar com valor
        // se o valor declarado for fora do intervalo permitido pela variável, vai dar erro
        byte numByte=-128;
        // (short numShort=32768;) só vai até 32767
        long numLong=123L;// o L reserva como long senão o JAVA assume int

        float numFloat=54.2F; // o F reserva como float senão o JAVA assume double
        double numDouble=14.52;

        boolean flag=true; // ou false
        char variableChar='D';

        String myString="a minha string";

        final double MY_PI=3.14; // declarar uma constante, nome deve estar sempre em maiúsculas

        // byte < short < int < long < float < double
    }
}
