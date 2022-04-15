package com.EasyInsurranceBrokers.dtos;

import java.math.BigDecimal;

public class ListaProductosCrud {
	private String nombre;
	private String categoria;
    private BigDecimal precio;
    private int cantidad;
    private String inventario;
    private String imagen;
    private int productoid;  
    
    public int getProductoId() {
		return productoid;
	}
	public void setProductoId(int productoid) {
		this.productoid = productoid;
	}
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getInventario() {
		return inventario;
	}
	public void setInventario(String inventario) {
		this.inventario = inventario;
	}
	
	public String getImagen() {
			return imagen;
    }
	
	public void setImagen(String imagen) {
			this.imagen = imagen;
	}
}
