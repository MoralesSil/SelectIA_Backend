package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Experiencia;
import pe.edu.upc.selecia_backend.repositories.ExperienciaRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.ExperienciaService;

import java.util.List;

@Service
public class ExperienciaServiceImplements implements ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public void insert(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }

    @Override
    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findById(int id) {
        return experienciaRepository.findById(id).orElse(null);
    }


}
