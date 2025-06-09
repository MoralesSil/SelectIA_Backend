package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Usuario;

import java.util.List;

public interface PerfilPostulanteService {
    void insert(PerfilPostulante perfilPostulante);

    List<PerfilPostulante> list();

    void delete(int id);

    PerfilPostulante findById(int id);

    PerfilPostulante findByUsuario(Usuario usuarioId);
}
