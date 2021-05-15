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
import ar.edu.unju.fi.tp5.model.Producto;
import ar.edu.unju.fi.tp5.service.ICompraService;
import ar.edu.unju.fi.tp5.service.IProductoService;



@Controller
public class CompraController {
	@Autowired
	private Compra compra;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	
	@GetMapping("/compras")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compra);
		model.addAttribute("productos", productoService.getAllProductos());
		return "compra-nueva";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView guardarCompraPage(@ModelAttribute("compra") Compra compra){
		ModelAndView modelView = new ModelAndView("compras-listado");
		compraService.guardarCompra(compra);
		modelView.addObject("compra-nueva", compraService.obtenerCompras());
		Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo());
		compra.setProducto(producto);
		compraService.guardarCompra(compra);
		modelView.addObject("compras", compraService.obtenerCompras());
		return modelView;
	}
}
