package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.Habilidad;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadService;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Habilidad habilidad) {
        habilidadService.insert(habilidad);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Habilidad>> listar() {
        List<Habilidad> lista = habilidadService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> buscarPorId(@PathVariable("id") int id) {
        Habilidad habilidad = habilidadService.findById(id);
        if (habilidad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habilidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        habilidadService.delete(id);
        return ResponseEntity.ok().build();
    }
}
