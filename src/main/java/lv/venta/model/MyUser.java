package lv.venta.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "MyUserTable") //mysql - product_table, H2 - MyUser_TABLE
@Entity
public class MyUser {
	//1. variables
	@Column(name = "UId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)//<-this means that setter for id will be not visible/usable
	private long uid; //TODO auto increment from DB
	
	

	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,20}", message = "Only letters are allowed and the first one should be capital. Size 2-20 ")
	//@Size(min = 3, max = 21) <- I can use it if there is no min or max inside the regex
	@Column(name = "Username")
	private String username;
	
	
	
	@NotNull
	//@Pattern(regexp = "[A-Za-z0-9 ,.;:]+")
	//@Size(min = 5, max = 100)
	@Column(name = "Password")
	private String password;
	
	

	//2. getters - lombok
	//3. setters - lombok
	//4. no argument constructor - lombok
	//5. argument constructors
	
	@ManyToOne
	@JoinColumn(name = "Aid")
	private MyAuthority authority;
	
	
	
	public MyUser(String username, String password)
	{
		setUsername(username);
		setPassword(password);
	}
	//6. toString function - lombok
	//7. other functions (if it is neccessary)
	

}



