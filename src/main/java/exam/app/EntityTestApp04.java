package exam.app;

import java.time.LocalDateTime;
import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp04 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		EntityTest01 entityTest01;
		for(int i=1; i<=5; i++) {
			entityTest01 = new EntityTest01();
			entityTest01.setName("또치" + i);
			entityTest01.setAge((int)(Math.random()*26 + 25));
			entityTest01.setBirthday(LocalDateTime.now());
			manager.persist(entityTest01);
			
		}
		
		manager.getTransaction().commit();
		
		TypedQuery<EntityTest01> query = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		List<EntityTest01> list = query.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.close();
		factory.close();
		
	}

}
