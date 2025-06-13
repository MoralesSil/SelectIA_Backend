package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.UsuarioDTO;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.RolService;
import pe.edu.upc.selecia_backend.serviceInterfaces.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<Usuario> lista = usuarioService.list();
        ModelMapper m = new ModelMapper();
        List<UsuarioDTO> listaDTO = lista.stream()
                .map(u -> m.map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") long id,
            @RequestBody UsuarioDTO usuarioDTO) {
        // Busca el usuario existente
        Usuario usuarioExistente = usuarioService.findById(id);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Mapea los datos del DTO al entity
        ModelMapper m = new ModelMapper();
        m.map(usuarioDTO, usuarioExistente);

        // Guarda el usuario actualizado
        usuarioService.insert(usuarioExistente);

        // Devuelve OK sin contenido (convención en PUT si no necesitas devolver el recurso)
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable("id") long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            ModelMapper m = new ModelMapper();
            UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioDTO> buscarPorCorreo(@PathVariable("correo") String correo) {
        Usuario usuario = usuarioService.findByCorreo(correo);
        if (usuario != null) {
            ModelMapper m = new ModelMapper();
            UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioDTO> buscarPorUsername(@PathVariable("username") String username) {
        Usuario usuario = usuarioService.findByUsername1(username);
        if (usuario != null) {
            ModelMapper m = new ModelMapper();
            UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
