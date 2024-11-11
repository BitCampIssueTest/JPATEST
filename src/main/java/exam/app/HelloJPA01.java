package exam.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HelloJPA01 {

	public static void main(String[] args) {
		// persitence.xml 에서 설정한 이름 <persistence-unit name="entitytest">
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		System.out.println("EntityManagerFactory = " + factory.getClass().getName());
		
		EntityManager manager = factory.createEntityManager();
		System.out.println("EntityManager = " + manager.getClass().getName());				
		
		manager.close();
		factory.close();
	
	}

}
