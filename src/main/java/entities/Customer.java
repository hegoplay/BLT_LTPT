package entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@DiscriminatorValue("Customer")
public class Customer extends Person{
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;
	
	// cart property (Khang - 28/04/2024).
	private List<CD> cart = null;
	
}
