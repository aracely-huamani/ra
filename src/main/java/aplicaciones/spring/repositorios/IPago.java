package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.Pago;

@Repository
public interface IPago extends JpaRepository<Pago,Serializable> {
	public abstract Pago findById(Long id);
}
