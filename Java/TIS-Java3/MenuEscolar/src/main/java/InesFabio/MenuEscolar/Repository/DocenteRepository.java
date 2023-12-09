package InesFabio.MenuEscolar.Repository;

import InesFabio.MenuEscolar.Enums.Funcao;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import InesFabio.MenuEscolar.Model.Disciplina;
import InesFabio.MenuEscolar.Model.Docente;
import InesFabio.MenuEscolar.Model.NaoDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    List<Docente> findByCc(Integer ccFiltro);
    List<Docente> findByNif(Integer nifFiltro);
    List<Docente> findByNiss(Long nissFiltro);
    List<Docente> findByTipoContrato(TipoContrato tipoContratoFiltro);
    List<Docente> findByEspecializacoes(Disciplina especializacoesFiltro);
    List<Docente> findByAtivo(Boolean ativoFiltro);
    List<Docente> findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(String nome, String apelido);
}
