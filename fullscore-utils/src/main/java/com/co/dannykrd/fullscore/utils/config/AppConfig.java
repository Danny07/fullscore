package com.co.dannykrd.fullscore.utils.config;

import java.util.Locale;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class AppConfig {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es")); // por ejemplo, español
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(LocaleChangeInterceptor interceptor) {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(interceptor);
            }
        };
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }
	
	@Bean
	public GroupedOpenApi restApi() {
	    return GroupedOpenApi.builder()
	            .group("api")
	            .pathsToMatch("/api/**") // Solo incluir rutas que empiecen por /api/
	            .build();
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages"); // NO pongas .properties aquí
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/*@Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        //server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Danny Cardenas");
        myContact.setEmail("danny.sebastian61@gmail.com");

        Info information = new Info()
                .title("Users Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage users.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
	
	@Bean
	public GroupedOpenApi restApi() {
	    return GroupedOpenApi.builder()
	        .group("rest")
	        .addOpenApiCustomizer(openApi -> openApi.info(new Info()
	            .title("API REST")
	            .description("Solo los endpoints REST serán mostrados")
	            .version("1.0")))
	        .addOperationCustomizer((operation, handlerMethod) -> {
	            // Filtra métodos que solo estén en clases @RestController
	            if (handlerMethod.getBeanType().isAnnotationPresent(RestController.class)) {
	                return operation;
	            }
	            return null;
	        })
	        .build();
	}*/
	
}
