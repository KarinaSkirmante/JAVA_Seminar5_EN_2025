package lv.venta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductStatisticsService;

@Service
public class ProductStatisticsServiceImpl implements IProductStatisticsService{

	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public int calculateHowManyProducts() throws Exception {
		if(prodRepo.count() == 0)
		{
			throw new Exception("There is no product in DB");
		}
		int result = prodRepo.calculateTotalQuantity();
		return result;
	}

	@Override
	public float calculateTotalProductsValue() throws Exception {
		if(prodRepo.count() == 0)
		{
			throw new Exception("There is no product in DB");
		}
		int result = prodRepo.calculateTotalProductValues();
		return result;
	}

}
