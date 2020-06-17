package visa.SREIntern.init.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:Beans.xml"})
public class XMLConfiguration {
}
