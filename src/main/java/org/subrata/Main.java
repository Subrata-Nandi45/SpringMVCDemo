package org.subrata;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.subrata.config.WebConfig;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws LifecycleException {
        //Boiler plate
        Tomcat tomcat=new Tomcat();
        //listen 8080 port
        tomcat.setPort(8080);

        tomcat.getConnector();

        String contextPath="";
        String baseDoc=new File("src/main/webapp").getAbsolutePath();
        Context context=tomcat.addContext(contextPath,baseDoc);

        //up IOC Container

       AnnotationConfigWebApplicationContext springContext=new AnnotationConfigWebApplicationContext();
       springContext.register(WebConfig.class);

        //Dispatcher Servlet
        DispatcherServlet dispatcherServlet=new DispatcherServlet(springContext);
        //i have to tell tomcat that dispatcher servlet is ready
        Tomcat.addServlet(context,"disparcherServlet",dispatcherServlet);
        context.addServletMappingDecoded("/","dispatcherServlet");

        tomcat.start();

        System.out.println("tomact started on port 80800");
        //keep server running
        tomcat.getServer().await();


    }
}