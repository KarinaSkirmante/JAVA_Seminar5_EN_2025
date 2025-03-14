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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
