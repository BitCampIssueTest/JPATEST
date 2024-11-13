package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA03 {
	
	public static void main(String[] args) throws InterruptedException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select emp from Emp emp", Emp.class); // JPQL, Emp = 엔티티 클래스
		List<Emp> list = query.getResultList();
		
		
		for(Emp emp : list) {
			System.out.println("직원명 : " + emp.getEname());
			Thread.sleep(1000);
			if(emp.getDeptno() != null) {
				System.out.println("부서명 : " + emp.getDeptno().getDname());
			}else {
				System.out.println("부서명 : 없음");
			}
		}
		
		System.out.println("데이터 총 개수 " + list.size());
		
		manager.close();
		factory.close();
	}
}
