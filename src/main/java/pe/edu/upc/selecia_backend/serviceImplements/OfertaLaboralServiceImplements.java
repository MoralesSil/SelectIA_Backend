package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.repositories.OfertaLaboralRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.OfertaLaboralService;

import java.util.List;

@Service
public class OfertaLaboralServiceImplements implements OfertaLaboralService {

    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;

    @Override
    public void insert(OfertaLaboral ofertaLaboral) {
        ofertaLaboralRepository.save(ofertaLaboral);
    }

    @Override
    public List<OfertaLaboral> list() {
        return ofertaLaboralRepository.findAll();
    }

    @Override
    public void delete(long id) {
        ofertaLaboralRepository.deleteById(id);
    }

    @Override
    public OfertaLaboral findById(long id) {
        return ofertaLaboralRepository.findById(id).orElse(null);
    }

    @Override
    public List<OfertaLaboral> findByEstado(Boolean estado) {
        return ofertaLaboralRepository.findByEstado(estado);
    }
}
