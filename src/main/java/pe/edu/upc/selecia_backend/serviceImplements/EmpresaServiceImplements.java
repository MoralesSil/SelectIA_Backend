package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Empresa;
import pe.edu.upc.selecia_backend.repositories.EmpresaRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.EmpresaService;


import java.util.List;

@Service
public class EmpresaServiceImplements implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void insert(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> list() {
        return empresaRepository.findAll();
    }

    @Override
    public void delete(long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa findById(long id) {
        return empresaRepository.findById(id).orElse(null);
    }

}
