package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}




/*
package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication, makes it a spring boot app, pretty obvious
//adds @Configuration: tags class as source of bean definition
//adds @EnableAutoConfiguration: tells Spring Boot to start adding beans based on classpath settings
//adds @EnableWebMvc: normally need to manually add Sprinv MVC app, spring boot does it automatically
//adds @Component Scan: tells Spring to look for other components in all packages (like hello here)
@SpringBootApplication
public class Application {

	//I guess it just runs a SpringApp upon its main function being called. 
	//Uses itself as the parameter so its just running itself
 	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	//This retrieves all beans created by this app or auto added by Spring Boot
	//it sorts them and prints them out
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
*/