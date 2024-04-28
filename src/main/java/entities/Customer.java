package entities;

import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@DiscriminatorValue("Customer")
@ToString
public class Customer extends Person implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6603037610178954819L;
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;
	
}
