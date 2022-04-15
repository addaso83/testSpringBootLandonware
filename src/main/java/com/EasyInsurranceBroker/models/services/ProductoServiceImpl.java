package com.EasyInsurranceBroker.models.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.EasyInsurranceBroker.models.dao.IProductoDao;
import com.EasyInsurranceBroker.models.entity.Producto;

import com.EasyInsurranceBrokers.dtos.ListaProductosCrud;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}
	
	@Override
	@Transactional
	public void saveProducto(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	public void deleteProducto(Producto producto) {
	     if(producto != null) {
	    	productoDao.delete(producto);
	     }
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findProductById(int id) {
		return  productoDao.findById(id).orElse(null);
	}

	
	
}
