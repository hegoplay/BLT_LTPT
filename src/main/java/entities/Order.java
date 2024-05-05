package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

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
	@jakarta.persistence.Id
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
//	fixed by HeGoPlay
	@jakarta.persistence.OneToMany(mappedBy = "order")
	private java.util.Set<OrderDetail> orderDetails;
	
	public double getTotal() {
		return orderDetails.stream().mapToDouble(od -> od.getSubTotal()).sum();
	}
}
