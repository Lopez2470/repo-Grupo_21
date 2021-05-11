package ar.edu.unju.fi.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Compra;
import ar.edu.unju.fi.tp5.service.ICompraService;



@Controller
public class CompraController {
	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	
	@GetMapping("/compras")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compra);
		return "compra-nueva";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView guardarComprae(@ModelAttribute("compra") Compra compra){
		ModelAndView modelView = new ModelAndView("compra-nueva");
		compraService.guardarCompra(compra);
		modelView.addObject("compra-nueva", compraService.obtenerCompras());
		return modelView;
	
	}
}
