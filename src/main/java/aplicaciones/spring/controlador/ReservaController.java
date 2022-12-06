package aplicaciones.spring.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.modelo.Reserva;
import aplicaciones.spring.servicios.ClienteService;
import aplicaciones.spring.servicios.DestinoService;
import aplicaciones.spring.servicios.ReservaService;

@Controller
@RequestMapping("/reservas")
@SessionAttributes("reserva")
public class ReservaController {
	
	@Autowired
	@Qualifier("reserva")
	ReservaService reservaService;	
	@Autowired
	@Qualifier("cliente")
	ClienteService clienteService;
	
	@Autowired
	@Qualifier("destino")
	DestinoService destinoService;
	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Reserva> reservas =reservaService.listar();
		model.addAttribute("reservas",reservas);
		model.addAttribute("titulo","Lista de Reservas");
		return "reservaListar";
	}	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Reserva reserva = new Reserva();
		model.put("reserva",reserva);
		model.put("destinos",destinoService.listar());
		model.put("clientes",clienteService.listar());
		model.put("btn", "Crear Reserva");
		return "reservaForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("reserva",reservaService.buscar(id));
		model.addAttribute("destinos",destinoService.listar());
		model.addAttribute("clientes",clienteService.listar());
		model.addAttribute("btn","Actualiza Reserva");
		return "reservaForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Reserva reserva,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar reserva");
			reserva = new Reserva();
			model.addAttribute("reserva",reserva);
			model.addAttribute("destinos",destinoService.listar());
			model.addAttribute("clientes",clienteService.listar());
			model.addAttribute("btn", "Crear Reserva");
			return "reservaForm";
		}else {
		reservaService.guardar(reserva);
		return "redirect:/reservas/listar";
		}
	}	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		reservaService.eliminar(id);
		return"redirect:/reservas/listar";
	}	

}
