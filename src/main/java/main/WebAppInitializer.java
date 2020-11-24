package main;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		AnnotationConfigWebApplicationContext webContext1 = new AnnotationConfigWebApplicationContext();
		webContext1.setParent(rootContext);
		webContext1.register(EmployeeWebConfig.class);
		webContext1.setServletContext(servletContext);
		ServletRegistration.Dynamic dispatcher1 = servletContext.addServlet("dispatcher1", new DispatcherServlet(webContext1));
		dispatcher1.addMapping("/employee/*");
		AnnotationConfigWebApplicationContext webContext2 = new AnnotationConfigWebApplicationContext();
		webContext2.setParent(rootContext);
		webContext2.register(ClientWebConfig.class);
		webContext2.setServletContext(servletContext);
		ServletRegistration.Dynamic dispatcher2 = servletContext.addServlet("dispatcher2", new DispatcherServlet(webContext2));
		dispatcher2.addMapping("/");
	}
	

}
