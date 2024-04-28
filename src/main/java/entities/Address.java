package entities;

import jakarta.persistence.Embeddable;

@Embeddable
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
public class Address implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7370205731677564447L;
	private String zip;
	private String city;
	private String street;
	private String number;
}
