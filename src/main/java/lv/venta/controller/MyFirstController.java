package lv.venta.controller;

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
		return "one-product-page";//it will show an one-product-page.html with test product (Banana, 1.99 eur ...)
		
	}
	//create new product
	//add this product in model
	//specify which html file should be showed
	//create the html file

}
