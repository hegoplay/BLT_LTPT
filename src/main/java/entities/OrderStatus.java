package entities;

@lombok.Getter
public enum OrderStatus implements java.io.Serializable{
	PENDING("Pending"), DELIVERED("Delivered"), VALIDATED("Validated"), DELIVERING("Delivering");
	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}
	
}
