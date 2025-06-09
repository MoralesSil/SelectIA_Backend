package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Notificaciones;
import pe.edu.upc.selecia_backend.entities.Usuario;

import java.util.List;

public interface NotificacionesService {
    void insert(Notificaciones notificacion);

    List<Notificaciones> list();

    void delete(int id);

    Notificaciones findById(int id);

    List<Notificaciones> findByUsuario(Usuario usuarioId);
}
