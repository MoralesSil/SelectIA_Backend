package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Educacion;
import pe.edu.upc.selecia_backend.repositories.EducacionRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.EducacionService;

import java.util.List;

@Service
public class EducacionServiceImplements implements EducacionService {
    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public void insert(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public List<Educacion> list() {
        return educacionRepository.findAll();
    }

    @Override
    public void delete(int id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion findById(int id) {
        return educacionRepository.findById(id).orElse(null);
    }


}
