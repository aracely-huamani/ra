package aplicaciones.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicaciones.spring.modelo.Pago;

import aplicaciones.spring.modelo.Reserva;

import aplicaciones.spring.servicios.ClienteService;
import aplicaciones.spring.servicios.DestinoService;
import aplicaciones.spring.servicios.PagoService;

import aplicaciones.spring.servicios.ReservaService;


@Controller
@RequestMapping("/pagos")
@SessionAttributes("pago")
public class PagoController {
		
	
	@Autowired
	@Qualifier("cliente")
	ClienteService clienteService;
	
	@Autowired
	@Qualifier("reserva")
	ReservaService reservaService;
	
	@Autowired
	@Qualifier("pago")
	PagoService pagoService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Pago> pagos = pagoService.listar();
		model.addAttribute("pagos",pagos);
		model.addAttribute("titulo","Lista de Pagos");
		return "pagoListar";
	}
	
	@RequestMapping("/form")
	public String formulario(Model model) {
		Pago pago= new Pago();
		model.addAttribute("pago", pago);
		model.addAttribute("reservas", reservaService.listar());
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("btn", "Registrar Pago");
		return "pagoForm";
	}
	//@RequestMapping(value="/insertar",method=RequestMethod.POST)
	//public String guardar(@Validated Pago pago, Model model) {
		//try {
			//String id = reserva.getPago();
			//Reserva reserva = reservaService.buscar(id);
				//double costo = reserva.getPago();
				//double igv = (costo*0.18);
				//double total = (costo+igv);
				//pago.setIgv(igv);
				//pago.setTotal(total);
				//pagoService.guardar(pago);
		//} catch (Exception e) {
		//}
		//return "redirect:/pagos/listar";

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		reservaService.eliminar(id);
		return "redirect:/pagos/listar";
	}
}
