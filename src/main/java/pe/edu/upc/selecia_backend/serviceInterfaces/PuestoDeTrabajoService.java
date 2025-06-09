package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;

import java.util.List;

public interface PuestoDeTrabajoService {
    void insert(PuestoDeTrabajo puestoDeTrabajo);

    List<PuestoDeTrabajo> list();

    void delete(int id);


    List<PuestoDeTrabajo> findByLugar(String lugar);
}
