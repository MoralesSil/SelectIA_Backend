package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.repositories.PerfilPostulanteRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilPostulanteService;

import java.util.List;

@Service
public class PerfilPostulanteServiceImplements implements PerfilPostulanteService {

    @Autowired
    private PerfilPostulanteRepository perfilPostulanteRepository;

    @Override
    public void insert(PerfilPostulante perfilPostulante) {
        perfilPostulanteRepository.save(perfilPostulante);
    }

    @Override
    public List<PerfilPostulante> list() {
        return perfilPostulanteRepository.findAll();
    }

    @Override
    public void delete(int id) {
        perfilPostulanteRepository.deleteById(id);
    }

    @Override
    public PerfilPostulante findById(int id) {
        return perfilPostulanteRepository.findById(id).orElse(null);
    }

    @Override
    public PerfilPostulante findByUsuario(Usuario usuarioId) {
        return perfilPostulanteRepository.findByUsuario(usuarioId);
    }
}
