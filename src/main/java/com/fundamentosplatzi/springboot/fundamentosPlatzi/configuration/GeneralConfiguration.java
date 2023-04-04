package com.fundamentosplatzi.springboot.fundamentosPlatzi.configuration;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class) // La clase se va a representar como propiedades dentro de nuestra aplicacion
@PropertySource("classpath:connection.properties")
@Configuration

public class GeneralConfiguration {
    //Notacion de Value llamar valores o propiedaes inicializadas en applicationproperties
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;
    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcurl;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean//Llamamos un Bean para utilizarlas
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name , lastname);
    }

    //Configuracion Manual a nivel de base de Datos
    @Bean
    public DataSource dataSource(){
        //Se relaciona toda la configuracion con la base de datos
        /*DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testDB");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");*/

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcurl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }
}
