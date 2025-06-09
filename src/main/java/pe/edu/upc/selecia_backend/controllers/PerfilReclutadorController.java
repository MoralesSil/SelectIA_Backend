package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.PerfilReclutador;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilReclutadorService;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles-reclutador")
public class PerfilReclutadorController {

    @Autowired
    private PerfilReclutadorService perfilReclutadorService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PerfilReclutador perfilReclutador) {
        perfilReclutadorService.insert(perfilReclutador);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PerfilReclutador>> listar() {
        List<PerfilReclutador> lista = perfilReclutadorService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilReclutador> buscarPorId(@PathVariable("id") int id) {
        PerfilReclutador perfil = perfilReclutadorService.findById(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        perfilReclutadorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
