package com.globocom.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private int maxUploadSizeInMb = 1024 * 1024 * 1024; // 1024 MB(1 GB)
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { AppConfig.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
   @Override
   protected void customizeRegistration(ServletRegistration.Dynamic registration) {

       // upload temp file will put here
       File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

       // register a MultipartConfigElement
       MultipartConfigElement multipartConfigElement =
               new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                       maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

       registration.setMultipartConfig(multipartConfigElement);

   }
}
