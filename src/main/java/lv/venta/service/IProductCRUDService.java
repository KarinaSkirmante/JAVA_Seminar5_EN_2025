package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.MyUser;

public interface IProductCRUDService {
	//CRUD
		
	//C - create
	public abstract void create(String inputTitle, float inputPrice, String inputDescription, 
			int inputQuantity) throws Exception ;
	
	//R - retrieve all
	public abstract ArrayList<MyUser> retrieveAll() throws Exception;
	
	//R - retrieve one by id
	public abstract MyUser retreiveById(long id) throws Exception;
	
	//U - update
	public abstract void updateById(long id, float inputPrice, String inputDescription, 
			int inputQuantity) throws Exception;
	
	//D - delete
	public abstract void deleteById(long id) throws Exception;

}
