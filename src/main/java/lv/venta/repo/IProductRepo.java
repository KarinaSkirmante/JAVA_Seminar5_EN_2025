package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
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


	//this will create SQL query:
	//SELECT * FROM product_table WHERE price < ?1;
	//?1 -> priceThreshold
	public abstract ArrayList<Product> findByPriceLessThanEqual(float priceThreshold);
	
	//this will create SQL query:
	//SELECT * FROM product_table WHERE title LIKE ?1 OR description LIKE ?2;
	//?1 -> text
	//?2 -> text2
	public abstract ArrayList<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String text,
			String text2);

	//this will create SQL query:
	//SELECT * FROM product_table WHERE quantity > ?1;
	//?1 -> quantityThreshold
	public abstract ArrayList<Product> findByQuantityGreaterThanEqual(int quantityThreshold);

	@Query(nativeQuery = true, value = "SELECT sum(quantity) FROM product_table;")
	public abstract int calculateTotalQuantity();


	@Query(nativeQuery = true, value = "SELECT sum(quantity*price) FROM product_table;")
	public abstract int calculateTotalProductValues();

}
