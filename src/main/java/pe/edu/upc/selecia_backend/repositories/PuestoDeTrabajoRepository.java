package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.PuestoDeTrabajo;

import java.util.List;

public interface PuestoDeTrabajoRepository extends JpaRepository<PuestoDeTrabajo, Integer> {
    List<PuestoDeTrabajo> findByLugarIgnoreCase(String lugar);
}
