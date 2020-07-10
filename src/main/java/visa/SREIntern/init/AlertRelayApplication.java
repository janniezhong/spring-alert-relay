package visa.SREIntern.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {}) //"visa.SREIntern.init.repositories","visa.SREIntern.init.domain"
public class AlertRelayApplication {

	private static final Logger LOGGER = LogManager.getLogger(AlertRelayApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AlertRelayApplication.class, args);

	}

}
