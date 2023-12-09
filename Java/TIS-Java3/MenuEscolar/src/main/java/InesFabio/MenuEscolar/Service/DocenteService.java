package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Enums.Funcao;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import InesFabio.MenuEscolar.Model.Disciplina;
import InesFabio.MenuEscolar.Model.Docente;
import InesFabio.MenuEscolar.Model.NaoDocente;
import InesFabio.MenuEscolar.Repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DocenteService {
// Atributos
    private final DocenteRepository docenteRepository;

// Construtores
    @Autowired
    public DocenteService(DocenteRepository docenteRepository) {this.docenteRepository = docenteRepository;}

// Métodos
    public Docente saveDocente(Docente docente){ return docenteRepository.save(docente); }

    public List<Docente> listDocente(){
        return docenteRepository.findAll();
    }
    public Optional<Docente> viewDocenteById(Long id){
        Optional<Docente> Docente=docenteRepository.findById(id);
        return Docente;
    }

    public Docente updateDocente(Long id, Docente docente){
        Optional<Docente> DocenteAtualizado=viewDocenteById(id);

        if(DocenteAtualizado.isPresent()){
             Docente _docente=DocenteAtualizado.get();
            _docente.setNome(docente.getNome());
            _docente.setApelido(docente.getApelido());
            _docente.setCc(docente.getCc());
            _docente.setDataNascimento(docente.getDataNascimento());
            _docente.setEspecie(docente.getEspecie());
            _docente.setSexo(docente.getSexo());
            _docente.setEmail(docente.getEmail());
            _docente.setTelefone(docente.getTelefone());
            _docente.setMorada(docente.getMorada());
            _docente.setCodPostal(docente.getCodPostal());
            _docente.setLocalidade(docente.getLocalidade());
            _docente.setAtivo(docente.getAtivo());
            _docente.setDetalhes(docente.getDetalhes());
            _docente.setTipoContrato((docente.getTipoContrato()));
            _docente.setNif(docente.getNif());
            _docente.setNiss(docente.getNiss());
            _docente.setIban(docente.getIban());
            _docente.setEspecializacoes(docente.getEspecializacoes());

            return docenteRepository.save(_docente);
        }

        return null;
    }

    public void deleteDocente(Long id) {
        docenteRepository.deleteById(id);
    }

    // Métodos Personalizados (opcionais)
    public List<Docente> listByCc(Integer ccFiltro){return docenteRepository.findByCc(ccFiltro);}
    public List<Docente> listByNif(Integer nifFiltro){return docenteRepository.findByNif(nifFiltro);}
    public List<Docente> listByNiss(Long nissFiltro){return docenteRepository.findByNiss(nissFiltro);}
    public List<Docente> listByTipoContrato(TipoContrato tipoContratoFiltro){return docenteRepository.findByTipoContrato(tipoContratoFiltro);}
    public List<Docente> listByEspecializacoes(Disciplina especializacoesFiltro){return docenteRepository.findByEspecializacoes(especializacoesFiltro);}
    public List<Docente> listByAtivo(Boolean ativoFiltro){return docenteRepository.findByAtivo(ativoFiltro);}
    public List<Docente> listByNome(String nomeFiltro){
        String[] palavrasChave=nomeFiltro.split(" ");
        List<Docente> docentesEncontrados=new ArrayList<>();
        for(String palavraChave:palavrasChave){
            List<Docente> docentesPorChave=docenteRepository.findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(palavraChave, palavraChave);
            docentesEncontrados.addAll(docentesPorChave);
        }
        Set<Docente> conjuntoDocentes=new HashSet<>(docentesEncontrados);
        docentesEncontrados.clear();
        docentesEncontrados.addAll(conjuntoDocentes);

        return docentesEncontrados;
    }
}
