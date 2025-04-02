package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.MyUser;

public interface IProductFilterService {

	public abstract ArrayList<MyUser> retrieveAllProductsPriceLessThan(float priceThreshold)
	throws Exception;
	
	public abstract ArrayList<MyUser> retrieveAllProductsTitleOrDesciprtionContainsText(String text)
	throws Exception;
		
	public abstract ArrayList<MyUser> retrieveAllproductsQuantityLargerThan(int quantityThreshold)
	throws Exception;
}
