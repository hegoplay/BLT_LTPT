package util;

public class ValidateForm {
//	write for me a vadidate an email code
	public static boolean isEmail(String email) {
		String regex = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,2}$";
		return email.matches(regex);
	}

//	write for me a validate a phone number code
	public static boolean isPhoneNumber(String phone) {
		String regex = "0[0-9]{9,11}";
		return phone.matches(regex);
	}
//	write for me a validate a zipcode
	public static boolean isZipCode(String zipCode) {
		String regex = "[0-9]{6}";
		return zipCode.matches(regex);
	}
}
