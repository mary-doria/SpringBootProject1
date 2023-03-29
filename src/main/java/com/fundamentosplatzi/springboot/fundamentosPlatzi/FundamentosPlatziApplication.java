package com.fundamentosplatzi.springboot.fundamentosPlatzi;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosPlatziApplication implements CommandLineRunner {
	//Inyectar la Interfaz
	//Atributos de la clase
	private ComponentDependency componentDependency;//Llamar nuestro Objeto
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

    //Constructor
	public FundamentosPlatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,MyBean myBean, MyBeanWithDependency myBeanWithDependency ){//Crear nuestro constructor de la clase
		this.componentDependency = componentDependency;
		this.myBean = myBean; //Llamamos a la propiedad myBean al paraemtro myBean
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosPlatziApplication.class, args);
	}

	@Override//Llamamos la implementacion segun el metodo
	public void run(String... args) throws Exception {
		componentDependency.saludar(); //Implementacion del metodo saludar
		myBean.print();//Implementacion del metodo print
		myBeanWithDependency.printWithDependency();//Llamo a la propiedad y a su implementacion
	}
}
