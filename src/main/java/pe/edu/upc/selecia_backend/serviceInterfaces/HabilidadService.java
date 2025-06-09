package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Habilidad;

import java.util.List;

public interface HabilidadService {
    void insert(Habilidad habilidad);

    List<Habilidad> list();

    void delete(int id);

    Habilidad findById(int id);
}
