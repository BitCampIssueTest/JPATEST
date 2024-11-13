package exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class EntityTest05 {
	@Id
	private int id;
	private String username;

	// 연관 관계 매핑 (join)
	@ManyToOne // 다 : 일
	private Team t; // DB의 필드명은 team_TEAM_ID 로 생성됨
					   // 자동부여가 싫으면 JoinColumn 사용
				  	   // ex) @JoinColumn(name = "LOCKER_ID")

	public EntityTest05() {
		// TODO Auto-generated constructor stub
	}

	public EntityTest05(String username, Team team) {
		this.username = username;
		this.t = team;
	}

}
