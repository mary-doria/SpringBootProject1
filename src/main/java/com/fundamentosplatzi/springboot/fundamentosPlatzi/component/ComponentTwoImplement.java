package com.fundamentosplatzi.springboot.fundamentosPlatzi.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("Hola Mundo desde mi Componente dos");
    }
}
