package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;
import pe.edu.upc.selecia_backend.serviceInterfaces.PuestoDeTrabajoService;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
public class PuestoDeTrabajoController {

    @Autowired
    private PuestoDeTrabajoService puestoDeTrabajoService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PuestoDeTrabajo puestoDeTrabajo) {
        puestoDeTrabajoService.insert(puestoDeTrabajo);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PuestoDeTrabajo>> listar() {
        List<PuestoDeTrabajo> lista = puestoDeTrabajoService.list();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        puestoDeTrabajoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lugar/{lugar}")
    public ResponseEntity<List<PuestoDeTrabajo>> buscarPorLugar(@PathVariable("lugar") String lugar) {
        List<PuestoDeTrabajo> lista = puestoDeTrabajoService.findByLugar(lugar);
        return ResponseEntity.ok(lista);
    }
}
