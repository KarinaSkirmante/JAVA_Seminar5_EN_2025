package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "ProductTable") //mysql - product_table, H2 - PRODUCT_TABLE
@Entity
public class Product {
	//1. variables
	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)//<-this means that setter for id will be not visible/usable
	private long id; //TODO auto increment from DB
	
	

	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,20}")
	//@Size(min = 3, max = 21) <- I can use it if there is no min or max inside the regex
	@Column(name = "Title")
	private String title;
	
	
	
	@Min(0)
	@Max(1000)
	@Column(name = "Price")
	private float price;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9 ,.;:]+")
	@Size(min = 5, max = 100)
	@Column(name = "Description")
	private String description;
	
	
	@Min(0)
	@Max(100)
	@Column(name = "Quantity")
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
