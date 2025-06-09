package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.serviceInterfaces.OfertaLaboralService;

import java.util.List;

@RestController
@RequestMapping("/api/ofertas-laborales")
public class OfertaLaboralController {

    @Autowired
    private OfertaLaboralService ofertaLaboralService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody OfertaLaboral ofertaLaboral) {
        ofertaLaboralService.insert(ofertaLaboral);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OfertaLaboral>> listar() {
        List<OfertaLaboral> lista = ofertaLaboralService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaLaboral> buscarPorId(@PathVariable("id") long id) {
        OfertaLaboral oferta = ofertaLaboralService.findById(id);
        if (oferta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oferta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        ofertaLaboralService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<OfertaLaboral>> buscarPorEstado(@PathVariable("estado") Boolean estado) {
        List<OfertaLaboral> lista = ofertaLaboralService.findByEstado(estado);
        return ResponseEntity.ok(lista);
    }
}
