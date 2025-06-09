package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.OfertaLaboral;

import java.util.List;

public interface OfertaLaboralService {
    void insert(OfertaLaboral ofertaLaboral);

    List<OfertaLaboral> list();

    void delete(long id);

    OfertaLaboral findById(long id);

    List<OfertaLaboral> findByEstado(Boolean estado);
}
