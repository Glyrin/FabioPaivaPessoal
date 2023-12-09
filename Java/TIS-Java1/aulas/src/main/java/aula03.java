public class aula03 {
    public static void main(String[] args) {
        // Bliblioteca Math.
            System.out.println(Math.round(10.5));
            System.out.println(Math.max(7,10));
            System.out.println(Math.min(7,10));
            System.out.println(Math.sqrt(9));
            System.out.println(Math.abs(-7));
            System.out.println((int)(Math.random()*101)); // número aleatório entre 0 e 100
            System.out.println(Math.PI); // valor absoluto de pi
            System.out.println(Math.E); // Número de Euler

        //Condicionais
            /*
            if(cond1){

            }else if(cond2){

            }else{

            }
            */

            // Operador ternário
                int horas=20;
                String texto=(horas<18)?"Bom dia":"Boa tarde"; // não tem de ser String
                System.out.println(texto);

            /*
            switch(valor a verificar){
                case cond1:
                    System.out.println();
                    break;
                case cond2:
                    System.out.println();
                    break;
                default:
                    System.out.println();
            }
            */
    }
}
