package com.EasyInsurranceBroker.models.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.EasyInsurranceBroker.models.entity.Producto;

@Repository
public interface IProductoDao extends CrudRepository<Producto,Integer> {

}
