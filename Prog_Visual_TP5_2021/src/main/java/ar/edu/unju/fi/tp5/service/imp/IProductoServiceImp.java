package ar.edu.unju.fi.tp5.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Producto;
import ar.edu.unju.fi.tp5.service.IProductoService;





@Service
public class IProductoServiceImp implements IProductoService {
	
	@Autowired
	Producto producto;
	
	List<Producto> productos = new ArrayList<Producto>();
	
	private static final Log LOGGER = LogFactory.getLog(IProductoServiceImp.class);
	
	/*Se realiza el alta del producto nuevo a la lista 'productos'*/
	@Override
	public void altaProducto(Producto producto) {
		this.productos.add(producto);
		/**int indice = productos.size() -1;**/
		LOGGER.info("METHOD: altaProducto(Producto producto): Agrega el objeto Producto a la lista de productos");
		LOGGER.info("RESULT:" + productos.get(productos.size() -1));		
		
	}

	/*Se busca el ultimo objeto dado de alta*/
	@Override
	public Producto getUltimoEmpleado() {
		Producto aux_producto = productos.get(productos.size() -1);
		LOGGER.info("METHOD: getUltimoEmpleado(): Se realiza la busqueda del ultimo objeto Producto agregado a la lista de productos");
		LOGGER.info("RESULT:" +  productos.get(productos.size() -1));	
		return aux_producto;
	}

	@Override
	public Producto getProducto() {
		return this.producto;
	}

	/*Visualiza al ultimo producto dado de alta*/
	@Override
	public List<Producto> getAllProductos() {
		// TODO Auto-generated method stub
		return this.productos;
	}
	


}
