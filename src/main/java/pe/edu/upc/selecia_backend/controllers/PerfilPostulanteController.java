package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.PerfilPostulanteDTO;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilPostulanteService;
import pe.edu.upc.selecia_backend.serviceInterfaces.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfiles-postulante")
public class PerfilPostulanteController {

    @Autowired
    private PerfilPostulanteService perfilPostulanteService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PerfilPostulanteDTO perfilPostulanteDTO) {
        ModelMapper m = new ModelMapper();
        PerfilPostulante perfilPostulante = m.map(perfilPostulanteDTO, PerfilPostulante.class);
        perfilPostulanteService.insert(perfilPostulante);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PerfilPostulanteDTO>> listar() {
        List<PerfilPostulante> lista = perfilPostulanteService.list();
        ModelMapper m = new ModelMapper();
        List<PerfilPostulanteDTO> listaDTO = lista.stream()
                .map(p -> m.map(p, PerfilPostulanteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilPostulanteDTO> buscarPorId(@PathVariable("id") int id) {
        PerfilPostulante perfil = perfilPostulanteService.findById(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        PerfilPostulanteDTO dto = m.map(perfil, PerfilPostulanteDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        perfilPostulanteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<PerfilPostulanteDTO> buscarPorUsuario(@PathVariable("idUsuario") int idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario);
        PerfilPostulante perfil = perfilPostulanteService.findByUsuario(usuario);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        PerfilPostulanteDTO dto = m.map(perfil, PerfilPostulanteDTO.class);
        return ResponseEntity.ok(dto);
    }
}
