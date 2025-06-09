package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.HabilidadDTO;
import pe.edu.upc.selecia_backend.entities.Habilidad;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody HabilidadDTO habilidadDTO) {
        ModelMapper m = new ModelMapper();
        Habilidad habilidad = m.map(habilidadDTO, Habilidad.class);
        habilidadService.insert(habilidad);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HabilidadDTO>> listar() {
        List<Habilidad> lista = habilidadService.list();
        ModelMapper m = new ModelMapper();
        List<HabilidadDTO> listaDTO = lista.stream()
                .map(h -> m.map(h, HabilidadDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadDTO> buscarPorId(@PathVariable("id") int id) {
        Habilidad habilidad = habilidadService.findById(id);
        if (habilidad == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        HabilidadDTO dto = m.map(habilidad, HabilidadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        habilidadService.delete(id);
        return ResponseEntity.ok().build();
    }
}
