package com.EasyInsurranceBroker.models.services;

import java.util.List;

import com.EasyInsurranceBroker.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public void saveProducto(Producto producto);
	
	public void deleteProducto(Producto producto);
	
	public Producto findProductById(int id);
	

}
