package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.Experiencia;
import pe.edu.upc.selecia_backend.serviceInterfaces.ExperienciaService;

import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Experiencia experiencia) {
        experienciaService.insert(experiencia);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Experiencia>> listar() {
        List<Experiencia> lista = experienciaService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable("id") int id) {
        Experiencia experiencia = experienciaService.findById(id);
        if (experiencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(experiencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        experienciaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
