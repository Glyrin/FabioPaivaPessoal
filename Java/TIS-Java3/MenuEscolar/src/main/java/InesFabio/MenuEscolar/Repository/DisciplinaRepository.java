package InesFabio.MenuEscolar.Repository;

import InesFabio.MenuEscolar.Model.Disciplina;
import InesFabio.MenuEscolar.Model.Turma;
import InesFabio.MenuEscolar.Model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
// Métodos Personalizados (opcionais)
    List<Disciplina> findByTurmas(Turma turma);
    List<Disciplina> findByProfessores(Docente docente);
}
