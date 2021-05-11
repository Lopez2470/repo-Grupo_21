package ar.edu.unju.fi.tp5.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Producto;
import ar.edu.unju.fi.tp5.service.IProductoService;




@Controller
public class ProductoController {
	private static final Log  LOGGER = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	IProductoService productoService;
	/*Pagina para ingresar los campos de Producto*/
	@GetMapping("/producto")
	public String getProductoFormPage(Model model) {
		model.addAttribute("producto", productoService.getProducto());
		LOGGER.info("METHOD: getProductoFormPage()");
		LOGGER.info("RESULT: Visualiza la pagina producto-nuevo.html");
		return "producto-nuevo";
	}
	/*Pagina que informa el alta del producto nuevo*/
	@PostMapping("/producto/guardar")
	public String getProductoResultadosPage(@ModelAttribute("producto") Producto unProducto ) {
		productoService.altaProducto(unProducto);
		return "producto-nuevo";
	}
	
	/*Pagina para detallar el ultimo producto dado de alta*/
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProductoPage() {
		ModelAndView modelView = new ModelAndView("producto-ultimo");
		modelView.addObject("producto", productoService.getUltimoEmpleado());
		LOGGER.info("METHOD: getUltimoProductoPage()");
		LOGGER.info("RESULT: Visualiza la pagina producto-ultimo.html");
		return modelView;
	}
	
	/*Pagina que visualiza los productos ingresados*/
	/*@GetMapping("/producto/listado")
	public String getProductoListadoPage(Model model){
		model.addAttribute("productos", productoService.getAllProductos());
		LOGGER.info("METHOD: getProductoListadoPage()");
		LOGGER.info("RESULT: Visualiza la pagina producto-listado.html");
		return"producto-listado";
	}
*/
	@GetMapping("/producto/listado")
	public ModelAndView getProductoListadoPage(Model model) {
		ModelAndView modelView = new ModelAndView("producto-listado");
		if (productoService.getAllProductos()==null) {
			productoService.getProducto();
		}
		modelView.addObject("productos", productoService.getAllProductos());
		
		return modelView;}
	

	@GetMapping("/home")
	public String getPageHome() {
		return("home");
	}
}

