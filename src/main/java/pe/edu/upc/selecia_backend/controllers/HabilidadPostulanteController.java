package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.HabilidadPostulante;
import pe.edu.upc.selecia_backend.serviceInterfaces.HabilidadPostulanteService;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad-postulante")
public class HabilidadPostulanteController {

    @Autowired
    private HabilidadPostulanteService habilidadPostulanteService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody HabilidadPostulante habilidadPostulante) {
        habilidadPostulanteService.insert(habilidadPostulante);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HabilidadPostulante>> listar() {
        List<HabilidadPostulante> lista = habilidadPostulanteService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadPostulante> buscarPorId(@PathVariable("id") int id) {
        HabilidadPostulante habilidadPostulante = habilidadPostulanteService.findById(id);
        if (habilidadPostulante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habilidadPostulante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        habilidadPostulanteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
