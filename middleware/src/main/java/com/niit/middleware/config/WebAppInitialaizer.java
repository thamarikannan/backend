package com.niit.middleware.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.middleware.filter.CORSFilter;

//import com.fasterxml.classmate.Filter;


public class WebAppInitialaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RestConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
		
		public void addCorsMappings(CorsRegistry registry) {
			
			registry.addMapping("/**");
			
		}
		protected Filter[] getServletFilters() {
			Filter[] singleton =  { new CORSFilter() };
			return singleton;
			}
		
	}
	
	

