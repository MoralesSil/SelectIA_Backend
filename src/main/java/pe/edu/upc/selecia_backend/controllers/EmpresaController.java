package pe.edu.upc.selecia_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.entities.Empresa;
import pe.edu.upc.selecia_backend.serviceInterfaces.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Empresa empresa) {
        empresaService.insert(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listar() {
        List<Empresa> lista = empresaService.list();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable("id") long id) {
        Empresa empresa = empresaService.findById(id);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        empresaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
