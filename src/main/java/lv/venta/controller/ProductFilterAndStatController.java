package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductFilterService;
import lv.venta.service.IProductStatisticsService;

@Controller
@RequestMapping("/product/stats")
public class ProductFilterAndStatController {

	@Autowired
	private IProductFilterService filtService;
		
	@Autowired
	private IProductStatisticsService statsService;
	
	//TODO
	//get controller for price filtering
	
	@GetMapping("/price/{threshold}")//localhost:8080/product/stats/price/1
	public String getControllerAllProductsByPrice(@PathVariable(name = "threshold") float threshold, 
			Model model)
	{
		try {
			ArrayList<Product> filteredProducts = filtService.retrieveAllProductsPriceLessThan(threshold);
			model.addAttribute("box", filteredProducts);//will add products from DB in box
			return "show-all-product-page";//show-all-product-page.html will be shown with products from DB

		
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
		
		
	}
	
	
	//get controller for text filtering
	@GetMapping("/search/{text}")//localhost:8080/product/stats/search/eco
	public String getControllerSearchproductsByText(@PathVariable(name = "text") String text,
			Model model)
	{
		try {
			ArrayList<Product> filteredProducts = filtService.retrieveAllProductsTitleOrDesciprtionContainsText(text);
			model.addAttribute("box", filteredProducts);//will add products from DB in box
			return "show-all-product-page";//show-all-product-page.html will be shown with products from DB
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
	}
	//TODO at home
	//get controller for quantity filtering
	//get controller for calculation of total quantity of products
	//get controller for calculations of total value of products (in eur)
	
	
}
