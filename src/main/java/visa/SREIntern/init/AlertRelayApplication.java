package visa.SREIntern.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {}) //"visa.SREIntern.init.repositories","visa.SREIntern.init.domain"
public class AlertRelayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertRelayApplication.class, args);
	}

}
