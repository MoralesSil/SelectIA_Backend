package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.EmpresaDTO;
import pe.edu.upc.selecia_backend.entities.Empresa;
import pe.edu.upc.selecia_backend.serviceInterfaces.EmpresaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody EmpresaDTO empresaDTO) {
        ModelMapper m = new ModelMapper();
        Empresa empresa = m.map(empresaDTO, Empresa.class);
        empresaService.insert(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listar() {
        List<Empresa> lista = empresaService.list();
        ModelMapper m = new ModelMapper();
        List<EmpresaDTO> listaDTO = lista.stream()
                .map(e -> m.map(e, EmpresaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> buscarPorId(@PathVariable("id") long id) {
        Empresa empresa = empresaService.findById(id);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        EmpresaDTO dto = m.map(empresa, EmpresaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        empresaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
