package ar.edu.unju.fi.tp5.service;

import java.util.List;

import ar.edu.unju.fi.tp5.model.Producto;





public interface IProductoService {
	/* Agrega un nuevo producto a la base de datos*/
	public void altaProducto(Producto producto);
	
	/*Visualiza al ultimo producto dado de alta*/
	public Producto getUltimoEmpleado();
	
	public Producto getProducto();
	
	/*Visualiza todos los productos dados de alta*/
	public List<Producto> getAllProductos();
		
	/*Encontrar un producto a travez de su codigo*/
	public Producto getProductoPorCodigo(int codigo);	

}
