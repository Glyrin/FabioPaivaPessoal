import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import static com.sun.tools.javac.util.StringUtils.toUpperCase;

public class Perguntas {
    public static Professor prof(Professor professor) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Insira o nome: ");
        professor.setNome(input.nextLine());

        int nif=0;
        int tamanho=0;
        do {
            System.out.print("Insira o número de contribuinte: ");
            String nifTemp = input.next();
            tamanho= nifTemp.length();
            nif=Integer.parseInt(nifTemp);
        }while (tamanho!=9);
        professor.setNif(nif);

        int idade=0;
        do {
            System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
            String dataNascimentoTemp = input.next();
            LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
            professor.setDataNascimento(DataNascimento);

            idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
            professor.setIdade(idade);
        }while(idade<18 || idade>67);

        System.out.print("Insira o sexo (M/F)");
        String sexoTemp= input.next().toUpperCase();
        switch (sexoTemp){
            case "M":
                professor.setSexo("Masculino");
                break;
            case "F":
                professor.setSexo("Feminino");
                break;
        }

        professor.setRank("Professor");

        System.out.print("Insira a disciplina: ");
        professor.setDisciplina(input.next());

        return professor;
    }

    public static NaoDocente func(NaoDocente funcionario) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Insira o nome: ");
        funcionario.setNome(input.nextLine());

        int nif=0;
        int tamanho=0;
        do {
            System.out.print("Insira o número de contribuinte: ");
            String nifTemp = input.next();
            tamanho= nifTemp.length();
            nif=Integer.parseInt(nifTemp);
        }while (tamanho!=9);
        funcionario.setNif(nif);

        int idade=0;
        do {
            System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
            String dataNascimentoTemp = input.next();
            LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
            funcionario.setDataNascimento(DataNascimento);

            idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
            funcionario.setIdade(idade);
        }while(idade<18 || idade>67);

        System.out.print("Insira o sexo (M/F)");
        String sexoTemp=input.next().toUpperCase();
        switch (sexoTemp){
            case "M":
                funcionario.setSexo("Masculino");
                break;
            case "F":
                funcionario.setSexo("Feminino");
                break;
        }

        funcionario.setRank("Não Docente");

        System.out.print("Insira o departamento: ");
        funcionario.setDepartamento(input.next());

        return funcionario;
    }

    public static Aluno alu(Aluno aluno) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Insira o nome: ");
        aluno.setNome(input.nextLine());

        int nif=0;
        int tamanho=0;
        do {
            System.out.print("Insira o número de contribuinte: ");
            String nifTemp = input.next();
            tamanho= nifTemp.length();
            nif=Integer.parseInt(nifTemp);
        }while (tamanho!=9);
        aluno.setNif(nif);

        int idade=0;
        do {
            System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
            String dataNascimentoTemp = input.next();
            LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
            aluno.setDataNascimento(DataNascimento);

            idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
            aluno.setIdade(idade);
        }while(idade<5 || idade>25);

        System.out.print("Insira o sexo (M/F)");
        String sexoTemp=input.next().toUpperCase();
        switch (sexoTemp){
            case "M":
                aluno.setSexo("Masculino");
                break;
            case "F":
                aluno.setSexo("Feminino");
                break;
        }

        aluno.setRank("Aluno");

        int ano=0;
        do {
            System.out.print("Insira o ano: ");
            ano=input.nextInt();
        }while(ano<1 && ano>12);
        aluno.setAno(ano);
        return aluno;
    }

    public static void altprof(Professor[] professores, int i) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Nome: "+professores[i].getNome()+". Quer alterar? (S/N) ");
        String resp1=input.next().toUpperCase();
        if(resp1.equals("S")) {
            System.out.print("Insira o nome: ");
            input.nextLine();
            professores[i].setNome(input.nextLine());
        }

        System.out.print("NIF: "+professores[i].getNif()+". Quer alterar? (S/N) ");
        String resp2=input.next().toUpperCase();
        if(resp2.equals("S")) {
            int nif = 0;
            int tamanho = 0;
            do {
                System.out.print("Insira o número de contribuinte: ");
                String nifTemp = input.next();
                tamanho = nifTemp.length();
                nif = Integer.parseInt(nifTemp);
            } while (tamanho != 9);
            professores[i].setNif(nif);
        }

        System.out.print("Data de Nascimento: "+professores[i].getDataNascimento()+". Quer alterar? (S/N) ");
        String resp3=input.next().toUpperCase();
        if(resp3.equals("S")) {
            int idade = 0;
            do {
                System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
                input.nextLine();
                String dataNascimentoTemp = input.next();
                LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
                professores[i].setDataNascimento(DataNascimento);

                idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
                professores[i].setIdade(idade);
            } while (idade < 18 || idade > 67);
        }

        System.out.print("Sexo: "+professores[i].getSexo()+". Quer alterar? (S/N) ");
        String resp4=input.next().toUpperCase();
        if(resp4.equals("S")) {
            System.out.print("Insira o sexo (M/F)");
            String sexoTemp = input.next().toUpperCase();
            switch (sexoTemp) {
                case "M":
                    professores[i].setSexo("Masculino");
                    break;
                case "F":
                    professores[i].setSexo("Feminino");
                    break;
            }
        }

        System.out.print("Disciplina: "+professores[i].getDisciplina()+". Quer alterar? (S/N) ");
        String resp5=input.next().toUpperCase();
        if(resp5.equals("S")) {
            System.out.print("Insira a disciplina: ");
            professores[i].setDisciplina(input.next());
        }
    }

    public static void altfunc(NaoDocente[] funcionarios, int i) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Nome: "+funcionarios[i].getNome()+". Quer alterar? (S/N) ");
        String resp1=input.next().toUpperCase();
        if (resp1.equals("S")) {
            System.out.print("Insira o nome: ");
            input.nextLine();
            funcionarios[i].setNome(input.nextLine());
        }

        System.out.print("NIF: "+funcionarios[i].getNif()+". Quer alterar? (S/N) ");
        String resp2=input.next().toUpperCase();
        if(resp2.equals("S")) {
            int nif = 0;
            int tamanho = 0;
            do {
                System.out.print("Insira o número de contribuinte: ");
                String nifTemp = input.next();
                tamanho = nifTemp.length();
                nif = Integer.parseInt(nifTemp);
            } while (tamanho != 9);
            funcionarios[i].setNif(nif);
        }

        System.out.print("Data de Nascimento: "+funcionarios[i].getDataNascimento()+". Quer alterar? (S/N) ");
        String resp3=input.next().toUpperCase();
        if(resp3.equals("S")) {
            int idade = 0;
            do {
                System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
                String dataNascimentoTemp = input.next();
                LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
                funcionarios[i].setDataNascimento(DataNascimento);

                idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
                funcionarios[i].setIdade(idade);
            } while (idade < 18 || idade > 67);
        }

        System.out.print("Sexo: "+funcionarios[i].getSexo()+". Quer alterar? (S/N) ");
        String resp4=input.next().toUpperCase();
        if(resp4.equals("S")) {
            System.out.print("Insira o sexo (M/F)");
            String sexoTemp = input.next().toUpperCase();
            switch (sexoTemp) {
                case "M":
                    funcionarios[i].setSexo("Masculino");
                    break;
                case "F":
                    funcionarios[i].setSexo("Feminino");
                    break;
            }
        }

        System.out.print("Departamento: "+funcionarios[i].getDepartamento()+". Quer alterar? (S/N) ");
        String resp5=input.next().toUpperCase();
        if(resp5.equals("S")) {
            System.out.print("Insira o departamento: ");
            funcionarios[i].setDepartamento(input.next());
        }
    }

    public static void altalu(Aluno[] alunos, int i) throws ParseException {
        Scanner input=new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Nome: "+alunos[i].getNome()+". Quer alterar? (S/N) ");
        String resp1=input.next().toUpperCase();
        if(resp1.equals("S")) {
            System.out.print("Insira o nome: ");
            input.nextLine();
            alunos[i].setNome(input.nextLine());
        }

        System.out.print("NIF: "+alunos[i].getNif()+". Quer alterar? (S/N) ");
        String resp2=input.next().toUpperCase();
        if(resp2.equals("S")) {
            int nif = 0;
            int tamanho = 0;
            do {
                System.out.print("Insira o número de contribuinte: ");
                String nifTemp = input.next();
                tamanho = nifTemp.length();
                nif = Integer.parseInt(nifTemp);
            } while (tamanho != 9);
            alunos[i].setNif(nif);
        }

        System.out.print("Data de Nascimento: "+alunos[i].getDataNascimento()+". Quer alterar? (S/N) ");
        String resp3=input.next().toUpperCase();
        if(resp3.equals("S")) {
            int idade = 0;
            do {
                System.out.print("Insira a data de nascimento no formato DD-MM-AAAA: ");
                String dataNascimentoTemp = input.next();
                LocalDate DataNascimento = CalcularIdade.DataNascimento(dataNascimentoTemp);
                alunos[i].setDataNascimento(DataNascimento);

                idade = CalcularIdade.CalcularIdade(dataNascimentoTemp);
                alunos[i].setIdade(idade);
            } while (idade < 5 || idade > 25);
        }

        System.out.print("Sexo: "+alunos[i].getSexo()+". Quer alterar? (S/N) ");
        String resp4=input.next().toUpperCase();
        if(resp4.equals("S")) {
            System.out.print("Insira o sexo (M/F)");
            String sexoTemp = input.next().toUpperCase();
            switch (sexoTemp) {
                case "M":
                    alunos[i].setSexo("Masculino");
                    break;
                case "F":
                    alunos[i].setSexo("Feminino");
                    break;
            }
        }

        System.out.print("Ano: "+alunos[i].getAno()+". Quer alterar? (S/N) ");
        String resp5=input.next().toUpperCase();
        if(resp5.equals("S")) {
            int ano = 0;
            do {
                System.out.print("Insira o ano: ");
                ano = input.nextInt();
            } while (ano < 1 && ano > 12);
            alunos[i].setAno(ano);
        }
    }
}
