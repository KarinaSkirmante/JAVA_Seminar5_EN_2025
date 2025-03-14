package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Product;


public interface IProductRepo extends CrudRepository<Product, Long> {

	
	//this will ceraet SQL query: 
	//SELECT * FROM product_table WHERE title=?1 and description = ?2 and price = ?3;
	//?1 -> inputTitle
	//?2 - > inputDescription
	//?3 -> inputPrice
	public abstract boolean existsByTitleAndDescriptionAndPrice(String inputTitle, String inputDescription, float inputPrice);

}
