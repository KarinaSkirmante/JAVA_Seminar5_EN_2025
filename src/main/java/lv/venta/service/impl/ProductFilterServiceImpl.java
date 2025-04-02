package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.MyUser;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;

@Service
public class ProductFilterServiceImpl implements IProductFilterService {

	@Autowired
	private IProductRepo prodRepo;
	
	
	@Override
	public ArrayList<MyUser> retrieveAllProductsPriceLessThan(float priceThreshold) throws Exception {
		if(priceThreshold < 0 || priceThreshold > 1000)
		{
			throw new Exception("Price can be 0 - 1000");
		}
		ArrayList<MyUser> result = prodRepo.findByPriceLessThanEqual(priceThreshold);
		if(result.isEmpty())
		{
			throw new Exception("There is no product that price is smaller than " + priceThreshold + " eur");
		}
		return result;
	}

	@Override
	public ArrayList<MyUser> retrieveAllProductsTitleOrDesciprtionContainsText(String text) throws Exception {
		if(text == null || text.length() == 0)
		{
			throw new Exception("There is a problem with searching text");
		}
		ArrayList<MyUser> result = 
		prodRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(text, text);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no product that contains text: " + text);
		}
		return result;
	}

	@Override
	public ArrayList<MyUser> retrieveAllproductsQuantityLargerThan(int quantityThreshold) throws Exception {
		if(quantityThreshold < 0 || quantityThreshold > 100)
		{
			throw new Exception("Qunatity can be 0 - 100");
		}
		ArrayList<MyUser> result = 
				prodRepo.findByQuantityGreaterThanEqual(quantityThreshold);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no product that quantity is larger than " + quantityThreshold );
			
		}
		return result;
	}

}
