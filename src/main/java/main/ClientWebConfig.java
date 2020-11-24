package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import main.client.interceptor.AccountCheckInterceptor;
import main.client.interceptor.GetNextPageInterceptor;
import main.client.interceptor.GetProductDetailsInterceptor;
import main.client.interceptor.GetProductInterceptor;
import main.client.interceptor.GetSearchResultInterceptor;
import main.client.interceptor.GetSortedNextPageInterceptor;
import main.client.interceptor.GetSortedProductInterceptor;
import main.client.interceptor.KeyCheckInterceptor;
import main.client.interceptor.PaymentInterceptor;
import main.client.interceptor.ProcessPaymentInterceptor;
import main.client.interceptor.RemoveFilterInterceptor;

@EnableWebMvc
@Configuration
@ComponentScans({
    @ComponentScan(basePackages="main.client"),
    @ComponentScan(basePackages="main.model.user.userrepository"),
    @ComponentScan(basePackages="main.model.order"),
    @ComponentScan(basePackages="main.model.shippingdetails")
})
public class ClientWebConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new KeyCheckInterceptor()).addPathPatterns(new String[] {"/authentication/signUp",
																						 "/authentication/signIn"});
		registry.addInterceptor(new AccountCheckInterceptor()).addPathPatterns(new String[] {"/authentication/getChangePasswordForm",
																			  				 "/authentication/changePassword",
																			  	  			 "/authentication/logOut",
																			  	  			 "/clientDetails/getOptions",
																			  	  			 "/clientDetails/getHistory"});
		registry.addInterceptor(new PaymentInterceptor()).addPathPatterns("/clientCart/doPayment");
		registry.addInterceptor(new GetNextPageInterceptor()).addPathPatterns("/clientService/getNextPage");
		registry.addInterceptor(new GetProductDetailsInterceptor()).addPathPatterns("/clientService/getProductDetails");
		registry.addInterceptor(new GetProductInterceptor()).addPathPatterns("/clientService/getProduct");
		registry.addInterceptor(new GetSortedNextPageInterceptor()).addPathPatterns("/clientService/getSortedProductNextPage");
		registry.addInterceptor(new GetSortedProductInterceptor()).addPathPatterns("/clientService/getSortedProduct");
		registry.addInterceptor(new RemoveFilterInterceptor()).addPathPatterns("/clientService/removeFilters");
		registry.addInterceptor(new GetSearchResultInterceptor()).addPathPatterns("/searchResult/getSearchResult");
		registry.addInterceptor(new ProcessPaymentInterceptor()).addPathPatterns("/clientCart/processPayment");
	}
	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/clientjs/**").addResourceLocations("classpath:/client/productview/");
		registry.addResourceHandler("/search/**").addResourceLocations("classpath:/client/clienthome/");
		registry.addResourceHandler("/productdetailsview/**").addResourceLocations("classpath:/client/productdetailsview/");
		registry.addResourceHandler("/clientcart/**").addResourceLocations("classpath:/client/clientcart/");
		registry.addResourceHandler("/paymentview/**").addResourceLocations("classpath:/client/paymentview/");
		registry.addResourceHandler("/paymentdoneview/**").addResourceLocations("classpath:/client/paymentdoneview/");
		registry.addResourceHandler("/pictures/**").addResourceLocations("/WEB-INF/images/");
	}
	
	
}


















































