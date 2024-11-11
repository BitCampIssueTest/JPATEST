package exam.app;

import java.time.LocalDateTime;
import java.util.Random;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Persistence;

public class EntityTestApp01 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();

		EntityTest01 entityTest01;

		// 트랜젝션 시작
		manager.getTransaction().begin();
//		@GeneratedValue(strategy = GenerationType.IDENTITY) 설정 하기 전
//		entityTest01 = new EntityTest01();
//		entityTest01.setId(10);
//		entityTest01.setName("홍길동");
//		entityTest01.setAge(25);
//		entityTest01.setBirthday(LocalDateTime.now());

//		@GeneratedValue(strategy = GenerationType.IDENTITY) 설정 후 
		for (int i = 1; i <= 5; i++) {
			entityTest01 = new EntityTest01();
			entityTest01.setName("홍길동" + i);
			entityTest01.setAge((int) (Math.random() * 26 + 25));
			entityTest01.setBirthday(LocalDateTime.now());

			manager.persist(entityTest01);
			
		}

		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}
}
