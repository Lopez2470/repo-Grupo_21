package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Compra;
import ar.edu.unju.fi.tp5.model.Producto;
import ar.edu.unju.fi.tp5.service.ICompraService;
import ar.edu.unju.fi.tp5.util.TablaCompra;

@Service("compraUtilService")
public class CompraServiceImp implements ICompraService {
	

	private List<Compra> compras;
	
	

	@Override
	public void generarTablaCompra() {
		compras = TablaCompra.listaCompras;
		compras.add(new Compra(1000,new Producto(110,"Producto01",1000.50,"Marca01",10),1,1000.50));
		
	}
	

	@Override
	public void guardarCompra(Compra compra) {
		if (compras==null) {
			generarTablaCompra();
		}
		compras.add(compra);

	}

	@Override
	public List<Compra> obtenerCompras() {
		return compras;
	}

}