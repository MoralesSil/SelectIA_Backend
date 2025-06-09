package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.Educacion;
import pe.edu.upc.selecia_backend.serviceInterfaces.EducacionService;

import java.util.List;

@RestController
@RequestMapping("/api/educaciones")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Educacion educacion) {
        educacionService.insert(educacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Educacion>> listar() {
        List<Educacion> lista = educacionService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Educacion> buscarPorId(@PathVariable("id") int id) {
        Educacion educacion = educacionService.findById(id);
        if (educacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(educacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        educacionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
