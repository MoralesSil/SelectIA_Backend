package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Postulacion;

import java.util.List;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
    List<Postulacion> findByPerfilPostulante(PerfilPostulante PerfilPostulante);
    List<Postulacion> findByOfertaLaboral(OfertaLaboral OfertaLaboral);
    boolean existsByPerfilPostulanteAndOfertaLaboral(PerfilPostulante perfil, OfertaLaboral oferta);


}
