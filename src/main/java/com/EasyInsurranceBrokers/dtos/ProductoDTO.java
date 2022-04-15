package com.EasyInsurranceBrokers.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoDTO implements Serializable  {
  static final long serialVersionUID = 1L;
  private int cantidad;
  private int existenciaminima;
  private String nombre;
  private int categoria;
  private BigDecimal precio;
  private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
  
	 public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getExistenciaminima() {
		return existenciaminima;
	}
	public void setExistenciaminima(int existenciaminima) {
		this.existenciaminima = existenciaminima;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}

