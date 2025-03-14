package lv.venta.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Product {
	//1. variables
	private long id; //TODO auto increment from DB
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,20}")
	//@Size(min = 3, max = 21) <- I can use it if there is no min or max inside the regex
	private String title;
	
	
	
	@Min(0)
	@Max(1000)
	private float price;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9 ,.;:]+")
	@Size(min = 5, max = 100)
	private String description;
	
	
	@Min(0)
	@Max(100)
	private int quantity;
	//2. getters - lombok
	//3. setters - lombok
	//4. no argument constructor - lombok
	//5. argument constructors
	public Product(String inputTitle, float inputPrice, String inputDescription, 
			int inputQuantity)
	{
		setTitle(inputTitle);
		setPrice(inputPrice);
		setDescription(inputDescription);
		setQuantity(inputQuantity);
	}
	//6. toString function - lombok
	//7. other functions (if it is neccessary)
	

}
