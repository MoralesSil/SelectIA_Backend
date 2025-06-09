package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.HabilidadPostulanteDTO;
import pe.edu.upc.selecia_backend.entities.HabilidadPostulante;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadPostulanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/habilidad-postulante")
public class HabilidadPostulanteController {

    @Autowired
    private HabilidadPostulanteService habilidadPostulanteService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody HabilidadPostulanteDTO habilidadPostulanteDTO) {
        ModelMapper m = new ModelMapper();
        HabilidadPostulante habilidadPostulante = m.map(habilidadPostulanteDTO, HabilidadPostulante.class);
        habilidadPostulanteService.insert(habilidadPostulante);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HabilidadPostulanteDTO>> listar() {
        List<HabilidadPostulante> lista = habilidadPostulanteService.list();
        ModelMapper m = new ModelMapper();
        List<HabilidadPostulanteDTO> listaDTO = lista.stream()
                .map(h -> m.map(h, HabilidadPostulanteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadPostulanteDTO> buscarPorId(@PathVariable("id") int id) {
        HabilidadPostulante habilidadPostulante = habilidadPostulanteService.findById(id);
        if (habilidadPostulante == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        HabilidadPostulanteDTO dto = m.map(habilidadPostulante, HabilidadPostulanteDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        habilidadPostulanteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
