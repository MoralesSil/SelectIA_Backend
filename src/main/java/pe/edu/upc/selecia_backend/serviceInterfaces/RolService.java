package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Rol;

import java.util.List;

public interface RolService {
    void insert(Rol rol);

    List<Rol> list();

    void delete(int id);

    Rol findById(int id);
}
