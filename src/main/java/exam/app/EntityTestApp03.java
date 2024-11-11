package exam.app;

import java.util.List;

import exam.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp03 {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person person1 = new Person();
		person1.setName("홍길긺ㄴ어리ㅏㅓㅁㄴㅇ리ㅏㅓ미낭러ㅣㅁㄴ어라ㅣ");
		person1.setAge(25);
		
		Person person2 = new Person();
		person2.setName("코난");
		person2.setAge(28);
		
		Person person3 = new Person();
		person3.setName("김태리");
		person3.setAge(30);
		
		manager.persist(person1);
		manager.persist(person2);
		manager.persist(person3);

		
		TypedQuery<Person> query = manager.createQuery("select p from Person p", Person.class);
		List<Person> list = query.getResultList();
		
		list.stream().forEach(e -> System.out.println(e));
		
		manager.getTransaction().commit();
		aksdlklajshdljfhlakjhdfkljhl
		안녕하세요
		manager.close();
		factory.close();
		
	}
}


// 새로운 Person 테이블의 엔티티 객체를 생성한 다음 데이터를 모두 조회하시오.
// 테이블 : Person
// 컬럼 : seq(기본키)name, age