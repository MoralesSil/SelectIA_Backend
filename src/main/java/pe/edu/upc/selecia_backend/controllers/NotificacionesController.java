package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.NotificacionesDTO;
import pe.edu.upc.selecia_backend.entities.Notificaciones;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.NotificacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody NotificacionesDTO notificacionDTO) {
        ModelMapper m = new ModelMapper();
        Notificaciones notificacion = m.map(notificacionDTO, Notificaciones.class);
        notificacionesService.insert(notificacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<NotificacionesDTO>> listar() {
        List<Notificaciones> lista = notificacionesService.list();
        ModelMapper m = new ModelMapper();
        List<NotificacionesDTO> listaDTO = lista.stream()
                .map(n -> m.map(n, NotificacionesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionesDTO> buscarPorId(@PathVariable("id") int id) {
        Notificaciones notificacion = notificacionesService.findById(id);
        if (notificacion == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        NotificacionesDTO dto = m.map(notificacion, NotificacionesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        notificacionesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<NotificacionesDTO>> buscarPorUsuario(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(usuarioId);
        List<Notificaciones> lista = notificacionesService.findByUsuario(usuario);
        ModelMapper m = new ModelMapper();
        List<NotificacionesDTO> listaDTO = lista.stream()
                .map(n -> m.map(n, NotificacionesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

}
