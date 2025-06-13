package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Postulacion;
import pe.edu.upc.selecia_backend.repositories.PostulacionRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.PostulacionService;

import java.util.List;

@Service
public class PostulacionServiceImplements implements PostulacionService {

    @Autowired
    private PostulacionRepository postulacionRepository;

    @Override
    public void insert(Postulacion postulacion) {
        postulacionRepository.save(postulacion);
    }

    @Override
    public List<Postulacion> list() {
        return postulacionRepository.findAll();
    }

    @Override
    public void delete(int id) {
        postulacionRepository.deleteById(id);
    }

    @Override
    public Postulacion findById(int id) {
        return postulacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Postulacion> findByPerfilPostulante(PerfilPostulante PerfilPostulante) {
        return postulacionRepository.findByPerfilPostulante(PerfilPostulante);
    }

    @Override
    public List<Postulacion> findByOfertaLaboral(OfertaLaboral ofertaId) {
        return postulacionRepository.findByOfertaLaboral(ofertaId);
    }

    @Override
    public Boolean existsByPerfilPostulante_IdPerfilAndOfertaLaboral_IdOferta(PerfilPostulante idPerfil, OfertaLaboral idOferta) {
        return postulacionRepository.existsByPerfilPostulanteAndOfertaLaboral(idPerfil,idOferta);
    }

}
