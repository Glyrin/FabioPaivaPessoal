package InesFabio.MenuEscolar.Repository;

import InesFabio.MenuEscolar.Enums.Funcao;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import InesFabio.MenuEscolar.Model.NaoDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaoDocenteRepository extends JpaRepository<NaoDocente, Long> {
    List<NaoDocente> findByCc(Integer ccFiltro);
    List<NaoDocente> findByNif(Integer nifFiltro);
    List<NaoDocente> findByNiss(Long nissFiltro);
    List<NaoDocente> findByTipoContrato(TipoContrato tipoContratoFiltro);
    List<NaoDocente> findByFuncoes(Funcao funcoesFiltro);
    List<NaoDocente> findByAtivo(Boolean ativoFiltro);
    List<NaoDocente> findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(String nome, String apelido);
}
