package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Rol;
import pe.edu.upc.selecia_backend.repositories.RolRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.RolService;

import java.util.List;

@Service
public class RolServiceImplements implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol findById(int id) {
        return rolRepository.findById(id).orElse(null);
    }
}
