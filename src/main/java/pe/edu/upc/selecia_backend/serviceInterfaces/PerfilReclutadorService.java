package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.PerfilReclutador;

import java.util.List;

public interface PerfilReclutadorService {
    void insert(PerfilReclutador perfilReclutador);

    List<PerfilReclutador> list();

    void delete(int id);

    PerfilReclutador findById(int id);


}
