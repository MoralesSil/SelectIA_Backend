package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;

import java.util.List;

public interface PuestoDeTrabajoService {
    void insert(PuestoDeTrabajo puestoDeTrabajo);

    List<PuestoDeTrabajo> list();

    void delete(int id);

    PuestoDeTrabajo findById_puesto(int id);

}
