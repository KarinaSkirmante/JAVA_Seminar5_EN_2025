package lv.venta.service;

public interface IProductStatisticsService {
	
	public abstract int calculateHowManyProducts() throws Exception;
	
	public abstract float calculateTotalProductsValue() throws Exception;

}
