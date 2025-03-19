package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Product;


public interface IProductRepo extends CrudRepository<Product, Long> {

	
	//this will create SQL query: 
	//SELECT * FROM product_table WHERE title=?1 and description = ?2 and price = ?3;
	//?1 -> inputTitle
	//?2 - > inputDescription
	//?3 -> inputPrice
	public abstract boolean existsByTitleAndDescriptionAndPrice(String inputTitle, String inputDescription, float inputPrice);

	
	//this will create SQL query: 
	//SELECT * FROM product_table WHERE title=?1 AND price = ?2 AND quantity=?3;
	//?1 -> inputTitle
	//?2 -> inputPrice
	//?3 -> inputDescription
	public abstract Product findByTitleAndPriceAndDescription(String inputTitle, float inputPrice,
			String inputDescription);

}
