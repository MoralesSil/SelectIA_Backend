package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.PerfilReclutador;
import pe.edu.upc.selecia_backend.repositories.PerfilReclutadorRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilReclutadorService;

import java.util.List;

@Service
public class PerfilReclutadorServiceImplements implements PerfilReclutadorService {

    @Autowired
    private PerfilReclutadorRepository perfilReclutadorRepository;

    @Override
    public void insert(PerfilReclutador perfilReclutador) {
        perfilReclutadorRepository.save(perfilReclutador);
    }

    @Override
    public List<PerfilReclutador> list() {
        return perfilReclutadorRepository.findAll();
    }

    @Override
    public void delete(int id) {
        perfilReclutadorRepository.deleteById(id);
    }

    @Override
    public PerfilReclutador findById(int id) {
        return perfilReclutadorRepository.findById(id).orElse(null);
    }


}
