package com.example.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
    	
    	 Alien obj1 = (Alien)factory.getBean("alien");
    	 obj1.code();
    	 obj1.age=15;
    	 System.out.println(obj1.age);
    	 
    	 
    	 Alien obj2 = (Alien)factory.getBean("alien");
    	 obj2.code();
    	 
    	 System.out.println(obj2.age);
    }
}
