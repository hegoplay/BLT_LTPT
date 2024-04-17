package entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Table(name = "cds")
public class CD {
	@Id
	@Column(name = "cd_id")
	private String cdID;
	private String name;
	private int quantity;
	private double price;
	private boolean status;
	@jakarta.persistence.OneToMany(mappedBy = "cd")
	private Set<OrderDetail> od;
}
