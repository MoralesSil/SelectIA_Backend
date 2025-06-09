package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Postulacion;
import pe.edu.upc.selecia_backend.serviceInterfaces.PostulacionService;

import java.util.List;

@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Postulacion postulacion) {
        postulacionService.insert(postulacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Postulacion>> listar() {
        List<Postulacion> lista = postulacionService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> buscarPorId(@PathVariable("id") int id) {
        Postulacion postulacion = postulacionService.findById(id);
        if (postulacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postulacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        postulacionService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/perfil-postulante/{perfilId}")
    public ResponseEntity<List<Postulacion>> buscarPorPerfilPostulante(@PathVariable("perfilId") int perfilId) {
        PerfilPostulante perfil = new PerfilPostulante();
        perfil.setId_perfil(perfilId);
        List<Postulacion> lista = postulacionService.findByPerfilPostulante(perfil);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/oferta-laboral/{ofertaId}")
    public ResponseEntity<List<Postulacion>> buscarPorOfertaLaboral(@PathVariable("ofertaId") int ofertaId) {
        OfertaLaboral oferta = new OfertaLaboral();
        oferta.setId_oferta(ofertaId);
        List<Postulacion> lista = postulacionService.findByOfertaLaboral(oferta);
        return ResponseEntity.ok(lista);
    }
}
