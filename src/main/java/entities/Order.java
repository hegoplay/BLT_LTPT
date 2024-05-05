package entities;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "orders")
public class Order implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8225572191751469055L;
	
	// Khang (04/05/2024) : OrderId field is modified to auto generated.
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String orderId;
	
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	@Embedded
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
