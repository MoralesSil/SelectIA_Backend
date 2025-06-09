package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.selecia_backend.entities.Notificaciones;
import pe.edu.upc.selecia_backend.entities.Usuario;

import java.util.List;

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    List<Notificaciones> findByUsuario(Usuario usuarioId);

}
