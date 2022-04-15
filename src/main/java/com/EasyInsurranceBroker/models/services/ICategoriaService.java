package com.EasyInsurranceBroker.models.services;
import java.util.List;

import com.EasyInsurranceBroker.models.entity.Categoria;

public interface ICategoriaService {
	public List<Categoria> findAll();

	public Categoria findById(int id);
}
