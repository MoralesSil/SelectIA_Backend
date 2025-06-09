package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.RolDTO;
import pe.edu.upc.selecia_backend.entities.Rol;
import pe.edu.upc.selecia_backend.serviceInterfaces.RolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody RolDTO rolDTO) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(rolDTO, Rol.class);
        rolService.insert(rol);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listar() {
        List<Rol> lista = rolService.list();
        ModelMapper m = new ModelMapper();
        List<RolDTO> listaDTO = lista.stream()
                .map(r -> m.map(r, RolDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        rolService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> buscarPorId(@PathVariable("id") int id) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            ModelMapper m = new ModelMapper();
            RolDTO dto = m.map(rol, RolDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
