package com.fundamentosplatzi.springboot.fundamentosPlatzi.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {//Inyectamos nuestra dependencia MyOperation
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("NIVEL DE INFORMACION!!!!");
        int numero=1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es:" + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
