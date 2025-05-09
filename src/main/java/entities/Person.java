package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@jakarta.persistence.DiscriminatorColumn(name = "person_type")
@jakarta.persistence.DiscriminatorValue("person")

public abstract class Person implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1407820700872230272L;
	@Id
	private String personID;
	@Column(name = "full_name", columnDefinition = "nvarchar(255)")
	private String name;
	private LocalDate dob;
	private Address address;
	private String email;
	@jakarta.persistence.OneToOne
	@jakarta.persistence.JoinColumn(name = "user_name")
	private Account account;
	@jakarta.persistence.Column(name = "regist_date")
	private LocalDate registDate;
}
