package com.fundamentosplatzi.springboot.fundamentosPlatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();//Agregar la palabra reservada new
    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();//Agregar la palabra reservada new
    }
    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependecy(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);//Agregar la palabra reservada new
    }
}
