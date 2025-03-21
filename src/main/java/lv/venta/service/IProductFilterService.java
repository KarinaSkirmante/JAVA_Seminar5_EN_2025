package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilterService {

	public abstract ArrayList<Product> retrieveAllProductsPriceLessThan(float priceThreshold)
	throws Exception;
	
	public abstract ArrayList<Product> retrieveAllProductsTitleOrDesciprtionContainsText(String text)
	throws Exception;
		
	public abstract ArrayList<Product> retrieveAllproductsQuantityLargerThan(int quantityThreshold)
	throws Exception;
}
