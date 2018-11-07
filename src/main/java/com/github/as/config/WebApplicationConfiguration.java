package com.github.as.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class, HibernateConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        this.addDispatcherServlet(servletContext);
        this.addUtf8EncodingFilter(servletContext);
    }

    private void addDispatcherServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(ServletConfiguration.class);
        applicationContext.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
        // dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private void addUtf8EncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("CHARACTER_ENCODING_FILTER",
                CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
        // filter.addMappingForUrlPatterns(null, false, "/*");
    }

}
