package com.fundamentosplatzi.springboot.fundamentosPlatzi.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    //Esta Clase va a recibir unos parametros
    private String name;
    private String lastname;
    public MyBeanWithPropertiesImplement(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }



    @Override
    public String function() {
        return name + "-" + lastname;
    }
}
