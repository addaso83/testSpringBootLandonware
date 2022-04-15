package com.EasyInsurranceBroker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.EasyInsurranceBroker.models.entity.Producto;
import com.EasyInsurranceBroker.models.services.IProductoService;
import com.EasyInsurranceBrokers.dtos.ListaProductosCrud;

import org.springframework.http.HttpStatus;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;

	@GetMapping("/productosCrud")
	public List<ListaProductosCrud> findAllProductosCrud(){
		
		List<Producto> productos = this.productoService.findAll();
		List<ListaProductosCrud> productosCrud = new ArrayList<ListaProductosCrud>();
		
		for(Producto el:productos) {
			ListaProductosCrud productoCrud = new ListaProductosCrud();
			productoCrud.setCantidad(el.getCantidad());
			productoCrud.setNombre(el.getNombre());
			productoCrud.setPrecio(el.getPrecio());
			productoCrud.setCategoria(el.getCategoria().getNombre());
		    productoCrud.setImagen(el.getImagen());
		    if(el.getCantidad()>el.getExistenciaMinima()) {
		    	productoCrud.setInventario("En stock");
		    }
		    if(el.getCantidad() > 0 && el.getCantidad()<= el.getExistenciaMinima()) {
		    	productoCrud.setInventario("Baja existencia");
		    }
		    if(el.getCantidad() == 0) {
		    	productoCrud.setInventario("Agotado");
		    }
		    productoCrud.setProductoId(el.getProductoid());
		    productosCrud.add(productoCrud);
		}
		
		
		
		return productosCrud;
	}
	
	@GetMapping("/productos")
	public List<Producto> findAll(){
		List<Producto> productos = productoService.findAll();
		return productos;
	}
	
	@GetMapping("/productos/{id}")
	public Producto findById(@PathVariable int id) {
		Producto producto = this.productoService.findProductById(id);
		return  producto;
	}

	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto saveProducto(@RequestBody Producto producto) {
		this.productoService.saveProducto(producto);
		return producto;
	}

	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto updateProducto(@RequestBody Producto producto, @PathVariable int id) {
		Producto productoActual = this.productoService.findProductById(id);
		productoActual.setCantidad(producto.getCantidad());
		productoActual.setNombre(producto.getNombre());
		productoActual.setExistenciaMinima(producto.getExistenciaMinima());
		productoActual.setCategoria(producto.getCategoria());
		productoActual.setPrecio(producto.getPrecio());
		productoActual.setImagen(producto.getImagen());
	    this.productoService.saveProducto(productoActual);	
		return productoActual;
	}

	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		Producto productoActual = this.productoService.findProductById(id);
		this.productoService.deleteProducto(productoActual);
	}
}
