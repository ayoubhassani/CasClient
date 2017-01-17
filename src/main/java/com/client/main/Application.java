/**
 * 
 */
package com.client.main;

import java.util.Arrays;

import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ayoub
 *
 */
@SpringBootApplication
@ComponentScan("com.client.*")
public class Application {
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("----------- Let's inspect the beans provided by Spring Boot: ----------");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			System.out.println("----------- End of list beans provided by Spring Boot: ----------");
		};
	}
	
	
	
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		//TODO: Configure Tomcat embided Server
//	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//	    factory.setPort(9000);
//	    factory.setSessionTimeout(10, TimeUnit.MINUTES);
//	    return factory;
//	}
	
	
	
}
