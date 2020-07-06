package com.stefanomaglione.youart;

import com.stefanomaglione.youart.repositories.UserRepository;
import com.stefanomaglione.youart.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;

//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring to turn on WebMVC (e.g., it should enable the DispatcherServlet
// so that requests can be routed to our Controllers)
@EnableWebMvc
// Tell Spring that this object represents a Configuration for the
// application
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
// Tell Spring to go and scan our controller package (and all sub packages) to
// find any Controllers or other components that are part of our applciation.
// Any class in this package that is annotated with @Controller is going to be
// automatically discovered and connected to the DispatcherServlet.
@ComponentScan
public class YouartApplication {

	private static final String MAX_REQUEST_SIZE = "150MB";

	public static void main(String[] args) {
		SpringApplication.run(YouartApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}

	@Bean(name="AppProperties")
	public AppProperties getAppProperties()
	{
		return new AppProperties();
	}

	// This configuration element adds the ability to accept multipart
	// requests to the web container.
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		// Setup the application container to be accept multipart requests
		final MultipartConfigFactory factory = new MultipartConfigFactory();
		// Place upper bounds on the size of the requests to ensure that
		// clients don't abuse the web container by sending huge requests
		factory.setMaxFileSize(DataSize.parse(MAX_REQUEST_SIZE));
		factory.setMaxRequestSize(DataSize.parse(MAX_REQUEST_SIZE));

		// Return the configuration to setup multipart in the container
		return factory.createMultipartConfig();
	}




}
