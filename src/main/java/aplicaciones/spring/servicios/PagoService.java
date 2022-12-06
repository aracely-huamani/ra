package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Pago;
import aplicaciones.spring.repositorios.IPago;

@Service("pago")
public class PagoService {
	@Autowired
	private IPago iPago;
	
	public void guardar(Pago pago) {
		iPago.save(pago);
	}	
	public List<Pago> listar(){
		 return iPago.findAll();
	}	
	public Pago buscar(Long id) {
		return iPago.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iPago.delete(iPago.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
