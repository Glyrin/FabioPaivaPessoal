public class aula07 {
    public static void main(String[] args) {
        // classe estabelece as regras a que os objetos vão obdecer
            // classe main começa a aplicação, tem de ter método main também
        // objeto é uma instância de uma classe
        // variável de instância = atributo = variável que é criada fora dos métodos

        Pessoa jonas = new Pessoa();
        // antes de definir os valores específicos devolve valores default para o tipo de dado
        //System.out.println(jonas.getNome());
        //System.out.println(jonas.idade);
        // depois de definir os valores, mostra os valores definidos
        jonas.setNome("Jonas");
        jonas.setAltura(1.74);
        jonas.setIdade(20);
        jonas.setPeso(75);
        //System.out.println(jonas.getNome()+" "+jonas.idade);
        //jonas.comer();
       // jonas.cumprimentar(jonas.getNome());

        // definir uma nova pessoa
        Pessoa joao = new Pessoa();
        joao.setNome("João");
        joao.setAltura(1.75);
        joao.setIdade(27);
        joao.setPeso(80);
        //System.out.println(joao.getNome()+" "+joao.idade);
        //joao.comer();
        //joao.cumprimentar(joao.getNome());

        Pessoa carlos=new Pessoa("Carlos", -100);
        System.out.println(carlos.getNome()+" "+carlos.getIdade()+" "+carlos.getAltura()+" "+carlos.getPeso());
        carlos.setAltura(1.9);
        System.out.println(carlos.getNome()+" "+carlos.getIdade()+" "+carlos.getAltura()+" "+carlos.getPeso());
    }
}
