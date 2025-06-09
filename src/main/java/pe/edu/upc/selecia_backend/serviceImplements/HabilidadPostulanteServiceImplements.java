package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.HabilidadPostulante;
import pe.edu.upc.selecia_backend.repositories.HabilidadPostulanteRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadPostulanteService;

import java.util.List;

@Service
public class HabilidadPostulanteServiceImplements implements HabilidadPostulanteService {

    @Autowired
    private HabilidadPostulanteRepository habilidadPostulanteRepository;

    @Override
    public void insert(HabilidadPostulante habilidadPostulante) {
        habilidadPostulanteRepository.save(habilidadPostulante);
    }

    @Override
    public List<HabilidadPostulante> list() {
        return habilidadPostulanteRepository.findAll();
    }

    @Override
    public void delete(int id) {
        habilidadPostulanteRepository.deleteById(id);
    }

    @Override
    public HabilidadPostulante findById(int id) {
        return habilidadPostulanteRepository.findById(id).orElse(null);
    }

}
