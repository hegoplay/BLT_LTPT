package entities;

@lombok.Getter
public enum OrderStatus {
	PENDING("Pending"), DELIVERED("Delivered"), VALIDATED("Validated"), DELIVERING("Delivering");
	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}
	
}
