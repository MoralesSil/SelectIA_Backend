package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.Notificaciones;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.NotificacionesService;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Notificaciones notificacion) {
        notificacionesService.insert(notificacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Notificaciones>> listar() {
        List<Notificaciones> lista = notificacionesService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificaciones> buscarPorId(@PathVariable("id") int id) {
        Notificaciones notificacion = notificacionesService.findById(id);
        if (notificacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notificacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        notificacionesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Notificaciones>> buscarPorUsuario(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(usuarioId);
        List<Notificaciones> lista = notificacionesService.findByUsuario(usuario);
        return ResponseEntity.ok(lista);
    }
}
