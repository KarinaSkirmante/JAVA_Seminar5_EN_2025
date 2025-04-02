package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@RestController
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService prodService;
	
	
	//CRUD
	//C - create
	
	@PostMapping("/create")
	public ResponseEntity<?> postControllerCreateNewProduct
	(@Valid @RequestBody Product product, BindingResult result) {//get product from html
		if(result.hasErrors()) {//is there any validation problem
			ResponseEntity response = new ResponseEntity(result.getAllErrors(), HttpStatusCode.valueOf(404));
			return response;
		}
		
		try {
			prodService.create(product.getTitle(), product.getPrice(),
					product.getDescription(), product.getQuantity());
			ArrayList<Product> allProducts = prodService.retrieveAll();
			ResponseEntity<ArrayList<Product>> response 
			= new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(404));
			return response;

		}
		
		
	}
	
	
	
	//R - retrieve all
	@GetMapping("/all")//localhost:8080/product/crud/all
	public ResponseEntity<?> getControllerAllProducts(Model model) {
		try
		{
			ArrayList<Product> allProducts = prodService.retrieveAll();
			ResponseEntity<ArrayList<Product>> response 
			= new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatusCode.valueOf(200));
			return response;
			
					}
		catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(404));
			return response;
		}
		}
	//R - retrieve by id (the first approach)
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
	
	//R - retrieve by id (the second approach)
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/3
	public ResponseEntity<?> getControllerOneProductById2(@PathVariable(name = "id") long id, Model model)
	{
		try
		{
			return new ResponseEntity<Product>(prodService.retreiveById(id), HttpStatusCode.valueOf(200));
		}
		catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(404));
			return response;

		}
	}
	
	
	//U - update by id
	@GetMapping("/update/{id}") //localhost:8080/product/crud/update/3
	public String getControllerUpdateProductById(@PathVariable(name = "id") long id, Model model) {
		try
		{
			Product productForUpdating = prodService.retreiveById(id);
			model.addAttribute("product", productForUpdating);
			return "update-product-page";
		}catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
		
	}
	
	@PostMapping("/update/{id}")
	public String postControllerUpdateProductById // product is updated product from HTML
	(@PathVariable(name = "id") long id, @Valid Product product, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "update-product-page";
		}
		
		try {
			prodService.updateById(id, product.getPrice(), product.getDescription(), product.getQuantity());
			return "redirect:/product/crud/all";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}

		
	}
	
	
	
	
	//D - delete by id
	@GetMapping("/delete/{id}")//localhost:8080/product/crud/delete/3
	public String getControllerDeleteProductById(@PathVariable(name = "id") long id, Model model)
	{
		try {
			prodService.deleteById(id);
			model.addAttribute("box", prodService.retrieveAll());//will add products from DB in box
			return "show-all-product-page";//show-all-product-page.html will be shown with products from DB

		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
		
	}
	
	
	
	
	

}
