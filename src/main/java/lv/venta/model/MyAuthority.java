package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "MyAuthorityTable")
@ToString
@Entity
public class MyAuthority {
	
	@Column(name = "Aid")
	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aid;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z ()]{4,40}")
	@Column(name = "title")
	private String title;
	
	public MyAuthority(String inputTitle)
	{
		setTitle(inputTitle);
	}
		

}
