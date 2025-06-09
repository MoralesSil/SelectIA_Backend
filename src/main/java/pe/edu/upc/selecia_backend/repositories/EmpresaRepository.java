package pe.edu.upc.selecia_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.selecia_backend.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
