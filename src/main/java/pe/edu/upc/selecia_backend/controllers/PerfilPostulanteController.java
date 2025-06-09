package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilPostulanteService;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles-postulante")
public class PerfilPostulanteController {

    @Autowired
    private PerfilPostulanteService perfilPostulanteService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PerfilPostulante perfilPostulante) {
        perfilPostulanteService.insert(perfilPostulante);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PerfilPostulante>> listar() {
        List<PerfilPostulante> lista = perfilPostulanteService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilPostulante> buscarPorId(@PathVariable("id") int id) {
        PerfilPostulante perfil = perfilPostulanteService.findById(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        perfilPostulanteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<PerfilPostulante> buscarPorUsuario(@PathVariable("idUsuario") int idUsuario) {
        // Aquí se asume que tienes un método para obtener Usuario por ID
        Usuario usuario = new Usuario();
        usuario.setId_usuario(idUsuario); // Asegúrate que el atributo se llame exactamente así en tu entidad Usuario
        PerfilPostulante perfil = perfilPostulanteService.findByUsuario(usuario);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }
}
