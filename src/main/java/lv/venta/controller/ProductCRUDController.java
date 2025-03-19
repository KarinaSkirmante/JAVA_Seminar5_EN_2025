package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/one")//localhost:8080/product/crud/one?id=3
	public String getControllerOneProductById(@RequestParam(name = "id") long id, Model model)
	{
		try
		{
			Product oneProduct = prodService.retreiveById(id);
			model.addAttribute("box", oneProduct);//will add only one product in box
			return "show-one-product-page";//this will show show-one-product-page.html with found product
		}
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
	}
	
	//U - update by id
	//D - delete by id
	
	
	
	
	
	

}
