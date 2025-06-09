package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Educacion;

import java.util.List;

public interface EducacionService {
    void insert(Educacion educacion);
    List<Educacion> list();
    void delete(int id);
    Educacion findById(int id);

}
