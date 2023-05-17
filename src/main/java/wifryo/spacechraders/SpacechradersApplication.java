package wifryo.spacechraders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@PropertySource("classpath:application-dev.properties")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebMvc
public class SpacechradersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacechradersApplication.class, args);
	}

}
