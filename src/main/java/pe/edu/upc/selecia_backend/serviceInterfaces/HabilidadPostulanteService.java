package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.HabilidadPostulante;

import java.util.List;

public interface HabilidadPostulanteService {
    void insert(HabilidadPostulante habilidadPostulante);

    List<HabilidadPostulante> list();

    void delete(int id);

    HabilidadPostulante findById(int id);

}
