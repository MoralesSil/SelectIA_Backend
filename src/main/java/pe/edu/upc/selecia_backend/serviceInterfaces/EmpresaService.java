package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Empresa;

import java.util.List;

public interface EmpresaService {
    void insert(Empresa empresa);

    List<Empresa> list();

    void delete(long id);

    Empresa findById(long id);
}
