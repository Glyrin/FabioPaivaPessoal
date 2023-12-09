import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;

    public class Main {
        public static void main(String[] args)throws ParseException{
            Scanner input=new Scanner(System.in).useLocale(Locale.US);

            Professor[] professores=new Professor[10];
            NaoDocente[] funcionarios=new NaoDocente[10];
            Aluno[] alunos=new Aluno[10];

            baseDados(professores, funcionarios, alunos);

            int opcao;
            do {
                System.out.println("O que pretende fazer?\nInsira o número correspondente da listagem seguinte:");
                System.out.println("1 - Inserir dados\n2 - Listar dados\n3 - Editar dados\n4 - Eliminar dados\n5 - Sair");
                System.out.print("Qual é a sua escolha? ");
                opcao = input.nextInt();
                System.out.println("\n-----\n");

                if (opcao == 1) {
                    inserir(professores, funcionarios, alunos);
                } else if (opcao == 2) {
                    listar(professores, funcionarios, alunos);
                } else if (opcao == 3) {
                    editar(professores, funcionarios, alunos);
                } else if (opcao == 4) {
                    eliminar(professores, funcionarios, alunos);
                } else if (opcao == 5) {
                    System.out.println("Programa encerrado. Obrigado");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }while(opcao!=5 || (opcao<1 && opcao>5));
            System.out.println("\n-----\n");
            input.close();
        }
        public static void inserir(Professor[] professores, NaoDocente[] funcionarios, Aluno[] alunos)throws ParseException{
            Scanner input=new Scanner(System.in).useLocale(Locale.US);
            int iProfessores=5;
            int iFuncionarios=5;
            int iAlunos=5;

            int opcao;
            do {
                System.out.println("Que tipo de utilizador quer inserir?\nInsira o número correspondente da listagem seguinte:");
                System.out.println("1 - Professor\n2 - Pessoal Não Docente\n3 - Aluno");
                System.out.print("Qual é a sua escolha? ");
                opcao = input.nextInt();
                System.out.println("\n-----\n");
            } while (opcao < 1 && opcao > 3);

            switch (opcao) {
                case 1:
                    Professor professor = new Professor();
                    Perguntas.prof(professor);
                    professores[iProfessores]=professor;
                    iProfessores++;
                    System.out.println("\nProfessor inserido com sucesso.");
                    break;
                case 2:
                    NaoDocente funcionario = new NaoDocente();
                    Perguntas.func(funcionario);
                    funcionarios[iFuncionarios]=funcionario;
                    iFuncionarios++;
                    System.out.println("\nNão Docente inserido com sucesso.");
                    break;
                case 3:
                    Aluno aluno = new Aluno();
                    Perguntas.alu(aluno);
                    alunos[iAlunos]=aluno;
                    iAlunos++;
                    System.out.println("\nAluno inserido com sucesso.");
                    break;
            }
            System.out.println("\n-----\n");
        }
        public static void listar(Professor[] professores, NaoDocente[] funcionarios, Aluno[] alunos){
            Scanner input=new Scanner(System.in).useLocale(Locale.US);

            int opcao;
            do {
                System.out.println("O que pretende listar?\nInsira o número correspondente da listagem seguinte:");
                System.out.println("1 - Professores\n2 - Pessoal Não Docente\n3 - Alunos\n4 - Todos");
                System.out.print("Qual é a sua escolha? ");
                opcao = input.nextInt();
                System.out.println("\n-----\n");
            } while (opcao < 1 && opcao > 4);

            switch (opcao) {
                case 1:
                    System.out.println("Listagem de professores:");
                    for (Professor pessoas:professores) {
                        if (pessoas instanceof Professor){
                            System.out.println(pessoas);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Listagem de não docentes:");
                    for (NaoDocente pessoas:funcionarios) {
                        if(pessoas instanceof NaoDocente) {
                            System.out.println(pessoas);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Listagem de alunos:");
                    for (Aluno pessoas:alunos) {
                        if (pessoas instanceof Aluno){
                            System.out.println(pessoas);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Listagem de todas as pessoas:");
                    for (Professor pessoas:professores) {
                        if (pessoas instanceof Professor){
                            System.out.println(pessoas);
                        }
                    }
                    for (NaoDocente pessoas:funcionarios) {
                        if(pessoas instanceof NaoDocente) {
                            System.out.println(pessoas);
                        }
                    }
                    for (Aluno pessoas:alunos) {
                        if (pessoas instanceof Aluno){
                            System.out.println(pessoas);
                        }
                    }
                    break;
            }
            System.out.println("\n-----\n");
        }
        public static void editar(Professor[] professores, NaoDocente[] funcionarios, Aluno[] alunos) throws ParseException {
            Scanner input=new Scanner(System.in).useLocale(Locale.US);

            int opcao, tempNif;
            do {
                System.out.println("O que pretende editar?\nInsira o número correspondente da listagem seguinte:");
                System.out.println("1 - Professor\n2 - Pessoal Não Docente\n3 - Aluno");
                System.out.print("Qual é a sua escolha? ");
                opcao = input.nextInt();
                System.out.println("\n-----\n");
            } while (opcao < 1 && opcao > 3);

            System.out.print("Insira o NIF da pessoa a editar: ");
            tempNif=input.nextInt();

            switch (opcao) {
                case 1:
                    for (int i=0; i<professores.length; i++) {
                        if (professores[i] != null && professores[i].getNif() == tempNif) {
                            Perguntas.altprof(professores, i);
                            System.out.println("\nProfessor alterado com sucesso.");
                        }
                    }
                    break;
                case 2:
                    for (int i=0; i<funcionarios.length; i++) {
                        if (funcionarios[i] != null && funcionarios[i].getNif() == tempNif) {
                            Perguntas.altfunc(funcionarios, i);
                            System.out.println("\nNão Docente alterado com sucesso.");
                        }
                    }
                    break;
                case 3:
                    for (int i=0; i<alunos.length; i++) {
                        if (alunos[i] != null && alunos[i].getNif() == tempNif) {
                            Perguntas.altalu(alunos, i);
                            System.out.println("\nAluno alterado com sucesso.");
                        }
                    }
                    break;
            }
            System.out.println("\n-----\n");
        }
        public static void eliminar(Professor[] professores, NaoDocente[] funcionarios, Aluno[] alunos){
            Scanner input=new Scanner(System.in).useLocale(Locale.US);

            int opcao, tempNif;
            do {
                System.out.println("O que pretende eliminar?\nInsira o número correspondente da listagem seguinte:");
                System.out.println("1 - Professor\n2 - Pessoal Não Docente\n3 - Aluno");
                System.out.print("Qual é a sua escolha? ");
                opcao = input.nextInt();
                System.out.println("\n-----\n");
            } while (opcao < 1 && opcao > 3);

            System.out.print("Insira o NIF da pessoa a eliminar: ");
            tempNif=input.nextInt();

            switch (opcao) {
                case 1:
                    for (int i=0; i<professores.length; i++) {
                        if (professores[i] != null && professores[i].getNif() == tempNif) {
                            professores[i]=null;
                            System.out.println("\nProfessor eliminado com sucesso.");
                        }
                    }
                    break;
                case 2:
                    for (int i=0; i<funcionarios.length; i++) {
                        if (funcionarios[i] != null && funcionarios[i].getNif() == tempNif) {
                            funcionarios[i]=null;
                            System.out.println("\nNão Docente eliminado com sucesso.");
                        }
                    }
                    break;
                case 3:
                    for (int i=0; i<alunos.length; i++) {
                        if (alunos[i] != null && alunos[i].getNif() == tempNif) {
                            alunos[i]=null;
                            System.out.println("\nAluno eliminado com sucesso.");
                        }
                    }
                    break;
            }
            System.out.println("\n-----\n");
        }
        public static void baseDados(Professor[] professores, NaoDocente[] funcionarios, Aluno[] alunos) throws ParseException {

            professores[0]=new Professor("Ana Oliveira", 192345678, LocalDate.of(1990, 3, 10), "Feminino", "Professor", "Português");
            professores[1]=new Professor("Pedro Santos", 234567891, LocalDate.of(1985, 7, 15), "Masculino", "Professor", "Matemática");
            professores[2]=new Professor("Sofia Pereira", 123456789, LocalDate.of(1998, 11, 22), "Feminino", "Professor", "Ciências Naturais");
            professores[3]=new Professor("Miguel Costa", 198765432, LocalDate.of(1982, 9, 5), "Masculino", "Professor", "Inglês");
            professores[4]=new Professor("Maria Fernandes", 276543219, LocalDate.of(1995, 6, 30), "Feminino", "Professor", "Educação Física");

            funcionarios[0]=new NaoDocente("Ana Santos", 219876543, LocalDate.of(1992, 5, 12), "Feminino", "Não Docente", "Administrativo");
            funcionarios[1]=new NaoDocente("Pedro Silva", 128765432, LocalDate.of(1987, 9, 28), "Masculino", "Não Docente", "Segurança");
            funcionarios[2]=new NaoDocente("Sofia Almeida", 278901234, LocalDate.of(1999, 11, 3), "Feminino", "Não Docente", "Cantina");
            funcionarios[3]=new NaoDocente("Miguel Pereira", 245678912, LocalDate.of(1984, 7, 17), "Masculino", "Não Docente", "Administrativo");
            funcionarios[4]=new NaoDocente("Maria Ferreira", 218765432, LocalDate.of(1996, 2, 25), "Feminino", "Não Docente", "Limpeza");

            alunos[0]=new Aluno("João Silva", 213456789, LocalDate.of(2015, 5, 12), "Masculino", "Aluno", 3);
            alunos[1]=new Aluno("Ana Pereira", 217890123, LocalDate.of(2014, 9, 28), "Feminino", "Aluno", 4);
            alunos[2]=new Aluno("Pedro Oliveira", 287654321, LocalDate.of(2013, 11, 3), "Masculino", "Aluno", 5);
            alunos[3]=new Aluno("Sofia Almeida", 129876543, LocalDate.of(2012, 7, 17), "Feminino", "Aluno", 5);
            alunos[4]=new Aluno("Miguel Pereira", 281234567, LocalDate.of(2011, 2, 25), "Masculino", "Aluno", 7);

        }
    }
