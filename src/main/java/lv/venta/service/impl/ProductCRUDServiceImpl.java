package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{

	@Autowired
	private IProductRepo prodRepo;
	
	
	@Override
	public void create(String inputTitle, float inputPrice, String inputDescription, int inputQuantity)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("The Product DB table is empty");
		}
		ArrayList<Product> allProducts = (ArrayList<Product>) prodRepo.findAll();
		return allProducts;
	}

	@Override
	public Product retreiveById(long id) throws Exception {
		//TODO
		if(id <= 0)
		{
			throw new Exception("Id should positive");
		}
		if(!prodRepo.existsById(id)) {
			throw new Exception("The product with id " + id + " doesn't exist");
		}
		
		Product oneProduct = prodRepo.findById(id).get();
		return oneProduct;
	}

	@Override
	public void updateById(long id, float inputPrice, String inputDescription, int inputQuantity) throws Exception {
		if(inputPrice < 0 || inputPrice > 1000
				|| inputDescription == null || !inputDescription.matches("[A-Za-z0-9 ,.;:]+")
				|| inputQuantity < 0 || inputQuantity > 100)
		{
			throw new Exception("Problems with input params");
		}
		Product productForUpdate = retreiveById(id);
		productForUpdate.setPrice(inputPrice);
		productForUpdate.setDescription(inputDescription);
		productForUpdate.setQuantity(inputQuantity);
		
		prodRepo.save(productForUpdate);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Product productForDelete = retreiveById(id);
		prodRepo.delete(productForDelete);
		
	}

}
