package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Product;


public interface IProductRepo extends CrudRepository<Product, Long> {

}
