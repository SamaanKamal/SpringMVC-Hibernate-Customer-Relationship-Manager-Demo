package CustomersList.example.CustomersListDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("CustomersList.example.CustomersListDemo")
public class CustomersListDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersListDemoApplication.class, args);
	}

}
