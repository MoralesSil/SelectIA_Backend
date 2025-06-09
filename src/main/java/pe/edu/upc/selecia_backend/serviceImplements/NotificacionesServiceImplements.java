package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Notificaciones;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.repositories.NotificacionesRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.NotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplements implements NotificacionesService {

    @Autowired
    private NotificacionesRepository notificacionesRepository;

    @Override
    public void insert(Notificaciones notificacion) {
        notificacionesRepository.save(notificacion);
    }

    @Override
    public List<Notificaciones> list() {
        return notificacionesRepository.findAll();
    }

    @Override
    public void delete(int id) {
        notificacionesRepository.deleteById(id);
    }

    @Override
    public Notificaciones findById(int id) {
        return notificacionesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Notificaciones> findByUsuario(Usuario usuarioId) {
        return notificacionesRepository.findByUsuario(usuarioId);
    }
}
