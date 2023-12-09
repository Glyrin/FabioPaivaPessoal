package InesFabio.MenuEscolar.Model;

import java.util.List;

public class AtualizacaoTurmasDTO {
// Atributos
    private List<Long> idsAlunos;
    private List<Long> idsTurmas;

// Construtores
    public AtualizacaoTurmasDTO() {}
    public AtualizacaoTurmasDTO(List<Long> idsAlunos, List<Long> idsTurmas) {
        this.setIdsAlunos(idsAlunos);
        this.setIdsTurmas(idsTurmas);
    }

// Getters e Setters
    public List<Long> getIdsAlunos() {return idsAlunos;}
    public void setIdsAlunos(List<Long> idsAlunos) {this.idsAlunos = idsAlunos;}

    public List<Long> getIdsTurmas() {return idsTurmas;}
    public void setIdsTurmas(List<Long> idsTurmas) {this.idsTurmas = idsTurmas;}
}
