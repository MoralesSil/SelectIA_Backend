package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Habilidad;
import pe.edu.upc.selecia_backend.repositories.HabillidadRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadService;

import java.util.List;

@Service
public class HabilidadServiceImplements implements HabilidadService {

    @Autowired
    private HabillidadRepository habilidadRepository;

    @Override
    public void insert(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    @Override
    public List<Habilidad> list() {
        return habilidadRepository.findAll();
    }

    @Override
    public void delete(int id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public Habilidad findById(int id) {
        return habilidadRepository.findById(id).orElse(null);
    }
}
