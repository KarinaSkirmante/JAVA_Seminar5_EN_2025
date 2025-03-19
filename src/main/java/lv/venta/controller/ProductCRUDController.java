package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService prodService;
	
	
	//CRUD
	//C - create
	//R - retrieve all
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getControllerAllProducts(Model model) {
		try
		{
			ArrayList<Product> allProducts = prodService.retrieveAll();
			model.addAttribute("box", allProducts);//will add products from DB in box
			return "show-all-product-page";//show-all-product-page.html will be shown with products from DB
		}
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
		}
	//R - retrieve by id
	//U - update by id
	//D - delete by id
	
	
	
	
	
	

}
