package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.ExperienciaDTO;
import pe.edu.upc.selecia_backend.entities.Experiencia;
import pe.edu.upc.selecia_backend.serviceInterfaces.ExperienciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody ExperienciaDTO experienciaDTO) {
        ModelMapper m = new ModelMapper();
        Experiencia experiencia = m.map(experienciaDTO, Experiencia.class);
        experienciaService.insert(experiencia);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ExperienciaDTO>> listar() {
        List<Experiencia> lista = experienciaService.list();
        ModelMapper m = new ModelMapper();
        List<ExperienciaDTO> listaDTO = lista.stream()
                .map(e -> m.map(e, ExperienciaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaDTO> buscarPorId(@PathVariable("id") int id) {
        Experiencia experiencia = experienciaService.findById(id);
        if (experiencia == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        ExperienciaDTO dto = m.map(experiencia, ExperienciaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        experienciaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
