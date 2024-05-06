package entities;

import jakarta.persistence.Column;
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
	@Column(columnDefinition = "nvarchar(255)")
	private String city;
	@Column(columnDefinition = "nvarchar(255)")
	private String street;
	private String number;
}
