package com.EasyInsurranceBroker.models.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EasyInsurranceBroker.models.entity.Categoria;

@Repository
public interface ICategoriaDao extends CrudRepository<Categoria,Integer> {

}
