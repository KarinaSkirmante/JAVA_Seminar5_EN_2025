package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}
	
	//TODO need to be run automatically
	public CommandLineRunner testModel(IProductRepo prodRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product p1 = new Product("Banana", 1.99f, "Eco, yellow", 5);
				prodRepo.save(p1);
				
			}
		};
	}

}
