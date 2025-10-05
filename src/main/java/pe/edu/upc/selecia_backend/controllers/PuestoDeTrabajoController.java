package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.PuestoDeTrabajoDTO;
import pe.edu.upc.selecia_backend.dtos.UsuarioDTO;
import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.PuestoDeTrabajoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/puestos")
public class PuestoDeTrabajoController {

    @Autowired
    private PuestoDeTrabajoService puestoDeTrabajoService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PuestoDeTrabajoDTO puestoDeTrabajoDTO) {
        ModelMapper m = new ModelMapper();
        PuestoDeTrabajo puestoDeTrabajo = m.map(puestoDeTrabajoDTO, PuestoDeTrabajo.class);
        puestoDeTrabajoService.insert(puestoDeTrabajo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") int id,
            @RequestBody PuestoDeTrabajoDTO puestoDeTrabajoDTO) {
        // Busca el usuario existente
        PuestoDeTrabajo PuestoDeTrabajoExistente = puestoDeTrabajoService.findById(id);
        if (PuestoDeTrabajoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Mapea los datos del DTO al entity
        ModelMapper m = new ModelMapper();
        m.map(puestoDeTrabajoDTO, PuestoDeTrabajoExistente);

        // Guarda el usuario actualizado
        puestoDeTrabajoService.insert(PuestoDeTrabajoExistente);

        // Devuelve OK sin contenido (convención en PUT si no necesitas devolver el recurso)
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PuestoDeTrabajoDTO> buscarPorId(@PathVariable("id") int id) {
        PuestoDeTrabajo PuestoDeTrabajo = puestoDeTrabajoService.findById(id);
        if (PuestoDeTrabajo != null) {
            ModelMapper m = new ModelMapper();
            PuestoDeTrabajoDTO dto = m.map(PuestoDeTrabajo, PuestoDeTrabajoDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping
    public ResponseEntity<List<PuestoDeTrabajoDTO>> listar() {
        List<PuestoDeTrabajo> lista = puestoDeTrabajoService.list();
        ModelMapper m = new ModelMapper();
        List<PuestoDeTrabajoDTO> listaDTO = lista.stream()
                .map(p -> m.map(p, PuestoDeTrabajoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        puestoDeTrabajoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
