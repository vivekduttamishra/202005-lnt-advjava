package testapp02.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

public class Program {

		public static void main(String[] args) {
			//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/app.xml");
        
			ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
			EmployeeManager manager = context.getBean(EmployeeManager.class);
 
        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());
	}

}
