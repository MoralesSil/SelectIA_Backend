package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;

import java.util.List;

public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboral, Long> {
    List<OfertaLaboral> findByEstado(Boolean estado);

}
