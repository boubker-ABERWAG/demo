package fr.sofnul.bk.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebAppInitializer implements WebApplicationInitializer {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);
	
//	@Override
//  public void onStartup(ServletContext servletContext) throws ServletException {
//		// Create the 'root' Spring application context
//	      AnnotationConfigWebApplicationContext applicationContext =
//	        new AnnotationConfigWebApplicationContext();
//	      applicationContext.register(AppConfig.class);
//          servletContext.addListener(new ContextLoaderListener(applicationContext));
//      
////   // Create the dispatcher servlet's Spring application context
////      AnnotationConfigWebApplicationContext dispatcherContext =
////        new AnnotationConfigWebApplicationContext();
////      dispatcherContext.register(ServletContainer.class);
//      
//   // Register and map the dispatcher servlet
//      ServletRegistration.Dynamic dispatcher =
//    		  servletContext.addServlet("dispatcher", new ServletContainer());
//      dispatcher.setLoadOnStartup(1);
//      dispatcher.addMapping("/");
//      
//      LOG.info("WebAppInitializer =========================> {}" ,this.getClass().getSimpleName());
//  }
//
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextConfigLocation", "fr.sofnul.bk.demo.config");
        WebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
            servletContext.addListener(new ContextLoaderListener(rootAppContext));
        
        LOG.info("WebAppInitializer =========================> {}" ,this.getClass().getSimpleName());
    }
}
