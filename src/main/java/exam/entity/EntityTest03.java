package exam.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class EntityTest03 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 10)
	private String name;
	
	@Column(columnDefinition = "varchar(15) default '파랑'")
	private String favoriteColor;
	
	@Column(name = "age", nullable = false)
	private int num1;
	
	@Column(name="score", precision = 6, scale = 2) // 숫자가 6개, 소수이하 자리수 2자리, 9999.99 표현가능한 숫자
	private BigDecimal num2;
	
	@Lob
	private byte[] content1;
	
	@Lob
	private char[] content2;
	
	@Lob
	private String content3;
	
}
