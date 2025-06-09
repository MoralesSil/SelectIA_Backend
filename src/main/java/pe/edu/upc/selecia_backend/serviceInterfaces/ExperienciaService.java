package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Experiencia;

import java.util.List;

public interface ExperienciaService {
    void insert(Experiencia experiencia);

    List<Experiencia> list();

    void delete(int id);

    Experiencia findById(int id);

}
