package pe.edu.upc.selecia_backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.EducacionDTO;
import pe.edu.upc.selecia_backend.entities.Educacion;
import pe.edu.upc.selecia_backend.serviceInterfaces.EducacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/educaciones")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;


    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody EducacionDTO educacionDTO) {
        ModelMapper m=new ModelMapper();
        Educacion educacion = m.map(educacionDTO, Educacion.class);
        educacionService.insert(educacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<EducacionDTO>> listar() {
        ModelMapper m=new ModelMapper();
        List<Educacion> lista = educacionService.list();
        List<EducacionDTO> listaDTO = lista.stream()
                .map(e -> m.map(e, EducacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducacionDTO> buscarPorId(@PathVariable("id") int id) {
        Educacion educacion = educacionService.findById(id);
        if (educacion == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m=new ModelMapper();
        EducacionDTO dto = m.map(educacion, EducacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        educacionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
