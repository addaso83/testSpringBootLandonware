package com.EasyInsurranceBroker.models.entity;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productoid;

	private int cantidad;

	private int existenciaminima;

	private String imagen;

	private String nombre;

	private BigDecimal precio;

	@ManyToOne
	@JoinColumn(name="categoriaid")
	@JsonBackReference
	private Categoria categoria;

	public Producto() {
	}
	
	public Producto(int productoid, int cantidad, int existenciaminima,
			String imagen, String nombre, BigDecimal precio,Categoria categoria) {
		this.productoid = productoid;
		this.cantidad = cantidad;
		this.existenciaminima = existenciaminima;
		this.imagen = imagen;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public int getProductoid() {
		return this.productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getExistenciaMinima() {
		return this.existenciaminima;
	}

	public void setExistenciaMinima(int existenciaMinima) {
		this.existenciaminima = existenciaMinima;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}