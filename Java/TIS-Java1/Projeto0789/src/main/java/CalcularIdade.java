import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CalcularIdade {
    public static Date StringParaData(String dataFornecida) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data = formatter.parse(dataFornecida);
        return data;
    }

    public static LocalDate DataNascimento(String var1) throws ParseException {
        // Converter o String para o formato data
        Date dataNascimento=StringParaData(var1);

        // Converter a data para objeto LocalDate
        Instant instant = dataNascimento.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate dataFornecida = zone.toLocalDate();

        return dataFornecida;
    }

    public static int CalcularIdade(String var1)throws ParseException{
        // Converter o String para o formato data
        Date dataNascimento=StringParaData(var1);

        // Converter a data para objeto LocalDate
        Instant instant = dataNascimento.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate dataFornecida = zone.toLocalDate();

        // Calcular a diferença entre as duas datas
        Period period = Period.between(dataFornecida, LocalDate.now());
        // Devolver idade
        return period.getYears();
    }

    public static int IdadeConstrutor(LocalDate dataFornecida){
        // Calcular a diferença entre as duas datas
        Period period = Period.between(dataFornecida, LocalDate.now());
        // Devolver idade
        return period.getYears();
    }
}
