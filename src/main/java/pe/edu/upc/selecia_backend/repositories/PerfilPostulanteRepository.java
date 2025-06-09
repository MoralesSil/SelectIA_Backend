package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Usuario;

public interface PerfilPostulanteRepository extends JpaRepository<PerfilPostulante, Integer> {
    PerfilPostulante findByUsuario(Usuario usuarioId);
}
