package com.fundamentosplatzi.springboot.fundamentosPlatzi;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosPlatziApplication implements CommandLineRunner {
	 private final Log LOGGER = LogFactory.getLog(FundamentosPlatziApplication.class);
	//Inyectar la Interfaz
	//Atributos de la clase
	//Clases que se usan como dependencias
	private ComponentDependency componentDependency;//Llamar nuestro Objeto
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

    //Constructor
	public FundamentosPlatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){//Crear nuestro constructor de la clase
		this.componentDependency = componentDependency;
		this.myBean = myBean; //Llamamos a la propiedad myBean al paraemtro myBean
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosPlatziApplication.class, args);
	}

	/*@Override//Llamamos la implementacion segun el metodo
	public void run(String... args) throws Exception {
		componentDependency.saludar(); //Implementacion del metodo saludar
		myBean.print();//Implementacion del metodo print
		myBeanWithDependency.printWithDependency();//Llamo a la propiedad y a su implementacion
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		LOGGER.error("ESTO ES UN ERROR DEL APLICATIVO!");
	}*/
	@Override//Llamamos la implementacion segun el metodo
	public void run(String... args)  {
		//ejemplosAnteriores();
		//saveUsersInDataBase();
		//getInformationJpqlFromUser();
		//queryMethod();
		queryMethod2();


	}
	private void getInformationJpqlFromUser(){
		LOGGER.info("USUARIO CON EL METODO findByUserEmail: " +
				userRepository.findMyUserByEmail("mary@domain.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el Usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort" + user));
	}

	private void queryMethod(){
		userRepository.findByName("Mary")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query Method" + user));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("user" , "mary@domain.com" , "1999");
		User user2 = new User("user2" , "zoe@domain.com" , "2014");
		User user3 = new User("Atena" , "atena@domain.com" , "2018");
		User user4 = new User("Matt" , "matt@domain.com" , "2022");
		//User usergirl= new User("Neko" , "nekodelicioso@domain.com" , "2002");
		User user5 = new User("Venado" , "venado@domain.com" , "1997");
		User user6 = new User("Pollo" , "pollo@domain.com" , "2002");
		User user7 = new User("Pache" , "matt@domain.com" , "1975");
		User user8 = new User("Bear" , "venado@domain.com" , "1975");
		User user9 = new User("Gato" , "gato@domain.com" , "2001");
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user9);//Lista de tipo User
		list.stream().forEach(userRepository::save);
	//
	}

	private void queryMethod2(){

		/*userRepository.findByNameLike("%M%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLike" +  user));

		userRepository.findByNameOrEmail("%g%", null)
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail" +  user));
				*/


		userRepository.findByNameLike("%user%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLike" + user));

		userRepository.getAllByNameAndEmail("Mary" ,"mary@domain.com");

	}

	private  void ejemplosAnteriores(){
		componentDependency.saludar(); //Implementacion del metodo saludar
		myBean.print();//Implementacion del metodo print
		myBeanWithDependency.printWithDependency();//Llamo a la propiedad y a su implementacion
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());
		try { int value=10/0;
			LOGGER.error("Mi Valor es: " + value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero" + e);
		}
	}


}
