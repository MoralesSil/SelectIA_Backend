package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;
import pe.edu.upc.selecia_backend.repositories.PuestoDeTrabajoRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.PuestoDeTrabajoService;

import java.util.List;

@Service
public class PuestoDeTrabajoServiceImplements implements PuestoDeTrabajoService {

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Override
    public void insert(PuestoDeTrabajo puestoDeTrabajo) {
        puestoDeTrabajoRepository.save(puestoDeTrabajo);
    }

    @Override
    public List<PuestoDeTrabajo> list() {
        return puestoDeTrabajoRepository.findAll();
    }

    @Override
    public void delete(int id) {
        puestoDeTrabajoRepository.deleteById(id);
    }

    @Override
    public PuestoDeTrabajo findById(int id) {
        return puestoDeTrabajoRepository.findById(id).orElse(null);
    }


}