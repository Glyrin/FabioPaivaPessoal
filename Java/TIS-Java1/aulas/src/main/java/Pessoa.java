public class Pessoa {
    private String nome = "Pessoa";
    private double altura=1.5;
    private int idade;
    private double peso;
    // foram definidas as regras para mais tarde criarmos uma pessoa

    /*Zona dos construtores*/
    public Pessoa(){
        System.out.println("Estou a criar uma pessoa...");
    } // criamos um construtor usando o mesmo nome da classe

    public Pessoa(String nome, int idade){
        this.setNome(nome);
        this.setIdade(idade);
        this.setPeso(50);
    }

    /*Zona dos getters/setters*/

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return this.altura;
    }

    public int getIdade() {
        return this.idade;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        if(idade<0){
            this.idade=0;
        }else {
            this.idade = idade;
        }
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /*Zona dos métodos*/
    void dormir(){
        System.out.println("z z z z z z z ...");
    }
   void comer(){
        System.out.println("nom, nom, nom. nom...");
    }
    void mover(){
        System.out.println("Olha para mim a mexer-me!!");
    }
    void cumprimentar(String nome){
        System.out.println("Olá eu sou o/a "+nome);
    }
        // MODIFICADORES

    // Public - tem de ser escrito e está acessivel em toda a aplicação
    // Private - tem de ser escrito e só está acessivel dentro da classe
    // Default - não tem de se escrever e só está acessivel dentro do mesmo package
    // Protected - tem de se escrever e ???
}
