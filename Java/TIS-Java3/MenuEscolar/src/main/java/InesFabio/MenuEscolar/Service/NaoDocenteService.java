package InesFabio.MenuEscolar.Service;

import InesFabio.MenuEscolar.Enums.Funcao;
import InesFabio.MenuEscolar.Enums.TipoContrato;
import InesFabio.MenuEscolar.Model.NaoDocente;
import InesFabio.MenuEscolar.Repository.NaoDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NaoDocenteService {
// Atributos
    private final NaoDocenteRepository naoDocenteRepository;

// Construtores
    @Autowired
    public NaoDocenteService(NaoDocenteRepository naoDocenteRepository) {
        this.naoDocenteRepository = naoDocenteRepository;
    }

// Métodos Base (Obrigatórios)
    public NaoDocente saveNaoDocente(NaoDocente naoDocente){return naoDocenteRepository.save(naoDocente);}
    public List<NaoDocente> listNaoDocente(){
        return naoDocenteRepository.findAll();
    }
    public Optional<NaoDocente> viewNaoDocenteById(Long id){
        Optional<NaoDocente> naoDocente=naoDocenteRepository.findById(id);
        return naoDocente;
    }
    public NaoDocente updateNaoDocente(Long id, NaoDocente naoDocente){
        Optional<NaoDocente> naoDocenteAtualizado=viewNaoDocenteById(id);

        if(naoDocenteAtualizado.isPresent()){
            NaoDocente _naoDocente=naoDocenteAtualizado.get();
            _naoDocente.setNome(naoDocente.getNome());
            _naoDocente.setApelido(naoDocente.getApelido());
            _naoDocente.setCc(naoDocente.getCc());
            _naoDocente.setDataNascimento(naoDocente.getDataNascimento());
            _naoDocente.setEspecie(naoDocente.getEspecie());
            _naoDocente.setSexo(naoDocente.getSexo());
            _naoDocente.setEmail(naoDocente.getEmail());
            _naoDocente.setTelefone(naoDocente.getTelefone());
            _naoDocente.setMorada(naoDocente.getMorada());
            _naoDocente.setCodPostal(naoDocente.getCodPostal());
            _naoDocente.setLocalidade(naoDocente.getLocalidade());
            _naoDocente.setAtivo(naoDocente.getAtivo());
            _naoDocente.setDetalhes(naoDocente.getDetalhes());
            _naoDocente.setTipoContrato((naoDocente.getTipoContrato()));
            _naoDocente.setNif(naoDocente.getNif());
            _naoDocente.setNiss(naoDocente.getNiss());
            _naoDocente.setIban(naoDocente.getIban());
            _naoDocente.setFuncoes(naoDocente.getFuncoes());

            return naoDocenteRepository.save(_naoDocente);
        }

        return null;
    }
    public void deleteNaoDocente(Long id){
        naoDocenteRepository.deleteById(id);
    }

// Métodos Personalizados (opcionais)
    public List<NaoDocente> listByCc(Integer ccFiltro){return naoDocenteRepository.findByCc(ccFiltro);}
    public List<NaoDocente> listByNif(Integer nifFiltro){return naoDocenteRepository.findByNif(nifFiltro);}
    public List<NaoDocente> listByNiss(Long nissFiltro){return naoDocenteRepository.findByNiss(nissFiltro);}
    public List<NaoDocente> listByTipoContrato(TipoContrato tipoContratoFiltro){return naoDocenteRepository.findByTipoContrato(tipoContratoFiltro);}
    public List<NaoDocente> listByFuncao(Funcao funcoesFiltro){return naoDocenteRepository.findByFuncoes(funcoesFiltro);}
    public List<NaoDocente> listByAtivo(Boolean ativoFiltro){return naoDocenteRepository.findByAtivo(ativoFiltro);}
    public List<NaoDocente> listByNome(String nomeFiltro){
        String[] palavrasChave=nomeFiltro.split(" ");
        List<NaoDocente> naoDocentesEncontrados=new ArrayList<>();
        for(String palavraChave:palavrasChave){
            List<NaoDocente> naoDocentesPorChave=naoDocenteRepository.findByNomeContainingIgnoreCaseOrApelidoContainingIgnoreCase(palavraChave, palavraChave);
            naoDocentesEncontrados.addAll(naoDocentesPorChave);
        }
        Set<NaoDocente> conjuntoNaoDocentes=new HashSet<>(naoDocentesEncontrados);
        naoDocentesEncontrados.clear();
        naoDocentesEncontrados.addAll(conjuntoNaoDocentes);

        return naoDocentesEncontrados;
    }
}
