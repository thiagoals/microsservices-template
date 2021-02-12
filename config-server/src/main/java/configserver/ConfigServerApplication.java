package configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication implements CommandLineRunner{
	
	@Value("${spring.cloud.config.server.git.username}")
	private String username;
	
	@Value("${spring.cloud.config.server.git.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to HR - Microsservices");
		System.out.println("Github username = "+username);
		System.out.println("Github passowrd = "+password);
	}

}
