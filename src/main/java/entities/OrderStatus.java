package entities;

@lombok.Getter
public enum OrderStatus implements java.io.Serializable{
	PENDING("Pending"), DELIVERED("Delivered"), REJECTED("Rejected"), DELIVERING("Delivering");
	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}
	
}
