package InesFabio.MenuEscolar.Repository;

import InesFabio.MenuEscolar.Enums.Casa;
import InesFabio.MenuEscolar.Model.Aluno;
import InesFabio.MenuEscolar.Model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
// Métodos Personalizados (opcionais)
    List<Aluno> findByTurma(Turma turma);
    List<Aluno> findByAtivoTrue();
    List<Aluno> findByTurmaId(Long turmaFiltro);
    List<Aluno> findByCc(Integer ccFiltro);
    List<Aluno> findByCasa(Casa casaFiltro);
    List<Aluno> findByAtivo(Boolean ativoFiltro);
    List<Aluno> findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(String nome, String apelido);
}
