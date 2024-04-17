package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {
	@Id
	@jakarta.persistence.ManyToOne
	@jakarta.persistence.JoinColumn(name = "order_id")
	private Order order;
	@Id
	@jakarta.persistence.ManyToOne
	@jakarta.persistence.JoinColumn(name = "cd_id")
	private CD cd;
	private int quantity;
}
