package springAOP.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@EntityScan
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	private String name;
	private String lname;

}
