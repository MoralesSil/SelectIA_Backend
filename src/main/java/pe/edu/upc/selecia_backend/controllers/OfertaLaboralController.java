package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.OfertaLaboralDTO;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.serviceInterfaces.OfertaLaboralService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ofertas-laborales")
public class OfertaLaboralController {

    @Autowired
    private OfertaLaboralService ofertaLaboralService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody OfertaLaboralDTO ofertaLaboralDTO) {
        ModelMapper m = new ModelMapper();
        OfertaLaboral ofertaLaboral = m.map(ofertaLaboralDTO, OfertaLaboral.class);
        ofertaLaboralService.insert(ofertaLaboral);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OfertaLaboralDTO>> listar() {
        List<OfertaLaboral> lista = ofertaLaboralService.list();
        ModelMapper m = new ModelMapper();
        List<OfertaLaboralDTO> listaDTO = lista.stream()
                .map(o -> m.map(o, OfertaLaboralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaLaboralDTO> buscarPorId(@PathVariable("id") long id) {
        OfertaLaboral oferta = ofertaLaboralService.findById(id);
        if (oferta == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        OfertaLaboralDTO dto = m.map(oferta, OfertaLaboralDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        ofertaLaboralService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<OfertaLaboralDTO>> buscarPorEstado(@PathVariable("estado") Boolean estado) {
        List<OfertaLaboral> lista = ofertaLaboralService.findByEstado(estado);
        ModelMapper m = new ModelMapper();
        List<OfertaLaboralDTO> listaDTO = lista.stream()
                .map(o -> m.map(o, OfertaLaboralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
