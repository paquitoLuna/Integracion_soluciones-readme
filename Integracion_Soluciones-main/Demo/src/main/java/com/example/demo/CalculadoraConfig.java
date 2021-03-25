package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.context.ApplicationContext;

@EnableWs
@Configuration
public class CalculadoraConfig extends WsConfigurerAdapter {

    @Bean
    public XsdSchema calculadoraSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calculadora.xsd"));
    }

    @Bean
    public ServletRegistrationBean messageDispatcheServelet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformSchemaLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "calculadora")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calculadoraSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("calculadora");
        wsdl.setLocationUri("/ws/caluladora");
        wsdl.setTargetNamespace("http://www.example.org/calculadora");
        wsdl.setSchema(calculadoraSchema);
        return wsdl;
    }
}
