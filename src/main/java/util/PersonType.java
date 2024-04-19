package util;

public enum PersonType {
	NONE(" "),CUSTOMER("Khách hàng"), STORAGE_EMPLOYEE("NV Tồn Kho"), STATISCAL_EMPLOYEE("NV Thống kê");
	private String value;

	public String getValue() {
		return value;
	}
	
	PersonType(String value) {
		this.value = value;
	}
}
