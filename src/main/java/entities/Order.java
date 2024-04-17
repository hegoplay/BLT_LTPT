package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "orders")
public class Order {
	@jakarta.persistence.Id
	private String orderId;
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	private Address shippingAddress;
	@jakarta.persistence.ManyToOne
	@jakarta.persistence.JoinColumn(name = "employee_id")
	private StorageEmployee storageEmployee;
	@jakarta.persistence.ManyToOne
	@jakarta.persistence.JoinColumn(name = "customer_id")
	private Customer customer;
	@jakarta.persistence.Enumerated(jakarta.persistence.EnumType.STRING)
	private OrderStatus status;
	
}
