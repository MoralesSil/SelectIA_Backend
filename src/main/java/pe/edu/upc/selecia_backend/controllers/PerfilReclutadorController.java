package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.PerfilReclutadorDTO;
import pe.edu.upc.selecia_backend.entities.PerfilReclutador;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilReclutadorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfiles-reclutador")
public class PerfilReclutadorController {

    @Autowired
    private PerfilReclutadorService perfilReclutadorService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PerfilReclutadorDTO perfilReclutadorDTO) {
        ModelMapper m = new ModelMapper();
        PerfilReclutador perfilReclutador = m.map(perfilReclutadorDTO, PerfilReclutador.class);
        perfilReclutadorService.insert(perfilReclutador);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PerfilReclutadorDTO>> listar() {
        List<PerfilReclutador> lista = perfilReclutadorService.list();
        ModelMapper m = new ModelMapper();
        List<PerfilReclutadorDTO> listaDTO = lista.stream()
                .map(p -> m.map(p, PerfilReclutadorDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilReclutadorDTO> buscarPorId(@PathVariable("id") int id) {
        PerfilReclutador perfil = perfilReclutadorService.findById(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        PerfilReclutadorDTO dto = m.map(perfil, PerfilReclutadorDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        perfilReclutadorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
