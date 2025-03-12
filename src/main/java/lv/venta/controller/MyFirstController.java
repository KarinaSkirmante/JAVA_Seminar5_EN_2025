package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;

@Controller
public class MyFirstController {
	
	
	@GetMapping("/simple") //localhost:8080/simple
	public String getControllerSimple() {
		System.out.println("Simple controller is called");
		return "simple-page";//it will show a simple-page.html page
		
	}
	
	
	@GetMapping("/data") //localhost:8080/data
	public String getControllerData(Model model) {
		Random rand = new Random();
		System.out.println("Data controller is called");
		String data  = "Karina: " + rand.nextInt(0, 11);
		model.addAttribute("box", data);
		return "data-page";//it will show a data-page.html with data "Karina: 6"
	}
	
	@GetMapping("/testproduct")//localhost:8080/testproduct
	public String getControllerSendProduct(Model model) {
		Product testProduct = new Product("Banana", 1.99f, "Eco, yellow", 5);
		model.addAttribute("box", testProduct);
		return "show-one-product-page";//it will show a show-one-product-page.html with test product (Banana, 1.99 eur ...)
		
	}
	
	@GetMapping("/testallproducts")//localhost:8080/testallproducts
	public String getControllerSendMultipleProducts(Model model)
	{
		ArrayList<Product> allProducts = new ArrayList<Product>(
				Arrays.asList(
						new Product("Banana", 1.99f, "Eco, yellow", 5),
						new Product("Grapes", 4.99f, "Purple", 10),
						new Product("Watermelon", 5.99f, "Sweet", 2))
				);
		
		model.addAttribute("box", allProducts);
		return "show-all-product-page";//it will show a show-all-product-page.html with arraylist of products

	}

}
