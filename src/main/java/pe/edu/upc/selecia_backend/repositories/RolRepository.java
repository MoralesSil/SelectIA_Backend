package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
