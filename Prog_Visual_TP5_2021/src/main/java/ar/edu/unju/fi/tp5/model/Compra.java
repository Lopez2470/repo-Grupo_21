package ar.edu.unju.fi.tp5.model;

import org.springframework.stereotype.Component;

@Component
public class Compra {
	private int id;
	private Producto producto;
	private int cantidad;
	private double total;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(int id, ar.edu.unju.fi.tp5.model.Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double obtenerCalculoTotal() {
		double total = cantidad*producto.getPrecio();
		return total;
	}
	
	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
	
	
	
}
