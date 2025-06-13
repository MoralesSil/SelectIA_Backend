package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Postulacion;

import java.util.List;

public interface PostulacionService {
    void insert(Postulacion postulacion);

    List<Postulacion> list();

    void delete(int id);

    Postulacion findById(int id);

    List<Postulacion> findByPerfilPostulante(PerfilPostulante PerfilPostulante);

    List<Postulacion> findByOfertaLaboral(OfertaLaboral ofertaId);

    Boolean existsByPerfilPostulante_IdPerfilAndOfertaLaboral_IdOferta(PerfilPostulante idPerfil, OfertaLaboral idOferta);
}
