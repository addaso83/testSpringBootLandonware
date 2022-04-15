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

import com.EasyInsurranceBroker.models.entity.Categoria;
import com.EasyInsurranceBroker.models.entity.Producto;
import com.EasyInsurranceBroker.models.services.ICategoriaService;
import com.EasyInsurranceBroker.models.services.IProductoService;
import com.EasyInsurranceBrokers.dtos.ListaProductosCrud;
import com.EasyInsurranceBrokers.dtos.ListaCategorias;
import com.EasyInsurranceBrokers.dtos.ProductoDTO;

import org.springframework.http.HttpStatus;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<ListaCategorias> findAllCategorias(){
		List<Categoria> categorias = categoriaService.findAll();
		List<ListaCategorias> listaCategorias = new ArrayList<ListaCategorias>();
		
		for(Categoria el : categorias) {
			ListaCategorias categoria = new ListaCategorias();
			categoria.setCategoriaid(el.getCategoriaid());
			categoria.setNombre(el.getNombre());
			listaCategorias.add(categoria);
		}
		return listaCategorias;
	}

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
		    	productoCrud.setInventario("Limitado");
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
	
	@GetMapping("/productosById/{id}")
	public ProductoDTO findById(@PathVariable int id) {
		Producto producto = this.productoService.findProductById(id);
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setId(producto.getProductoid());
		productoDTO.setCategoria(producto.getCategoria().getCategoriaid());
		productoDTO.setCantidad(producto.getCantidad());
		productoDTO.setPrecio(producto.getPrecio());
		productoDTO.setExistenciaminima(producto.getExistenciaMinima());
		productoDTO.setNombre(producto.getNombre());
		return  productoDTO;
	}

	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoDTO saveProducto(@RequestBody ProductoDTO productoDTO) {
		Producto  producto = new Producto();
		producto.setCantidad(productoDTO.getCantidad());
		producto.setExistenciaMinima(productoDTO.getExistenciaminima());
		producto.setPrecio(productoDTO.getPrecio());
		Categoria categoria = categoriaService.findById(productoDTO.getCategoria());
		producto.setCategoria(categoria);
		producto.setNombre(productoDTO.getNombre());
		this.productoService.saveProducto(producto);
		productoDTO.setId(producto.getProductoid());
		return productoDTO;
	}

	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoDTO updateProducto(@RequestBody ProductoDTO productoDTO, @PathVariable int id) {
		Categoria categoria = categoriaService.findById(productoDTO.getCategoria());
		Producto productoActual = this.productoService.findProductById(id);
		productoActual.setCantidad(productoDTO.getCantidad());
		productoActual.setNombre(productoDTO.getNombre());
		productoActual.setExistenciaMinima(productoDTO.getExistenciaminima());
		productoActual.setCategoria(categoria);
		productoActual.setPrecio(productoDTO.getPrecio());
	    this.productoService.saveProducto(productoActual);	
		return productoDTO;
	}

	@DeleteMapping("/productosDelete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProducto(@PathVariable int id) {
		Producto productoActual = this.productoService.findProductById(id);
		this.productoService.deleteProducto(productoActual);
	}
}
