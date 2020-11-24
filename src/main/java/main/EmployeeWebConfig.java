package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import main.employee.addproductinterceptor.AddProductInterceptor;
import main.employee.getaddingforminterceptor.GetAddingFormInterceptor;
import main.employee.homeinterceptor.HomeInterceptor;
import main.employee.interceptor.KeyInterceptor;

@EnableWebMvc
@Configuration
@ComponentScans({
    @ComponentScan(basePackages="main.employee"), 
    @ComponentScan(basePackages="main.model.cookie"),
    @ComponentScan(basePackages="main.model.product")
})
public class EmployeeWebConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760);
		multipartResolver.setMaxUploadSizePerFile(1048576);
		return multipartResolver;
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HomeInterceptor()).addPathPatterns("/authentication/login");
		registry.addInterceptor(new AddProductInterceptor()).addPathPatterns("/adminworks/addProduct");
		registry.addInterceptor(new GetAddingFormInterceptor()).addPathPatterns(new String[] {"/adminworks/getAddingForm", "/adminworks/getSearchForm", "/backToHome"});
		registry.addInterceptor(new KeyInterceptor()).addPathPatterns(new String[] {"/adminworks/findProductById", "/adminworks/updateProduct", "/adminworks/removeProduct"});
	}
	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/employee/addproduct/");
		registry.addResourceHandler("/remove/**").addResourceLocations("classpath:/employee/getorremove/");
		registry.addResourceHandler("/pictures/**").addResourceLocations("/WEB-INF/images/");
	}

}


























